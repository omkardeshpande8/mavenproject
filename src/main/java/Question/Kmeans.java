package Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author omkar
 */
public class Kmeans {
    static class Point {

        double x;
        double y;
        Point centroid;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class CentroidCalculator{
        
        Point centroid;
        Integer count;

        public CentroidCalculator(Point c, Integer count) {
            this.centroid = c;
            this.count = count;
        }
        
    }
    
    private static void assignCentroids(ArrayList<Point> points, List<Point> centroids) {
        points.forEach((p) -> p.centroid = getClosestCentroid(p, centroids));
    }

    private static Point getClosestCentroid(Point p, List<Point> centroids) {
        Double distance = Double.MAX_VALUE;
        Point centroid = null;
        for (Point c : centroids) {
            double dist = getEuclideandistance(p, c);
            if (dist < distance) {
                centroid = c;
                distance = dist;
            }
        }

        return centroid;
    }

    private static double getEuclideandistance(Point p, Point c) {
        return Math.sqrt(Math.pow(p.x - c.x, 2) + Math.pow(p.y - c.y, 2));
    }

    private static List<Point> recomputeCenters(ArrayList<Point> points, HashMap<Point, CentroidCalculator> map) {
        for (Point p : points) {
            Point centroid = p.centroid;
            CentroidCalculator modifyCentroid = modifyCentroid(map.get(centroid), centroid);
            map.put(centroid, modifyCentroid);
        }
        return map.values().stream().map(m -> m.centroid).collect(Collectors.toList());
    }

    private static CentroidCalculator modifyCentroid(CentroidCalculator ccal, Point centroid) {
        Point new_centroid = ccal.centroid;
        int count = ccal.count;
        double x = ((new_centroid.x * count) + centroid.x) / ++count;
        double y = ((new_centroid.y * count) + centroid.y) / count;
        return new CentroidCalculator(new Point(x, y), count);
    }

    public static void main(String[] args) {
        int k = 10;
        ArrayList<Point> points = new ArrayList<>();
        List<Point> centroids = points.subList(0, k);
        int count = 0;
        List<Point> newCentroids = new ArrayList<>();

        while (newCentroids != centroids || count <= 5) {
            if(!newCentroids.isEmpty()){
                centroids = newCentroids;
            }
            assignCentroids(points, centroids);
            HashMap<Point, CentroidCalculator> map = new HashMap<>();
            centroids.forEach(c -> map.put(c, new CentroidCalculator(new Point(0, 0), 0)));
            newCentroids = recomputeCenters(points, map);
        }
    }
}
