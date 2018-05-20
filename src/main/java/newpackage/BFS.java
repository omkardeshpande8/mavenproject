package newpackage;

import java.util.*;

public class BFS {

    public static class Graph {

        ArrayList< List<Integer>> map;
        HashSet<Integer> visited = new HashSet<>();
        int size;

        public Graph(int size) {
            this.size = size;
            map = new ArrayList<>(size);
            map.forEach((l) -> {
                l = new LinkedList<>();
            });
        }

        public void addEdge(int first, int second) {
            map.get(first).add(second);
            map.get(second).add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(startId);

            int[] distances = new int[size];
            Arrays.fill(distances, -1);
            distances[startId] = 0;
            while (!queue.isEmpty()) {
                int id = queue.poll();
                visited.add(id);

                for (Integer node : map.get(id)) {
                    if (!visited.contains(node)) {
                        queue.offer(node);
                        distances[node] = distances[id] + 6;
                    }
                }
            }
            return distances;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = 2;

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(4);
            int m = 2;

            // read and set edges
//            for (int i = 0; i < m; i++) {
//                int u = scanner.nextInt() - 1;
//                int v = scanner.nextInt() - 1;
//                
            // add each edge to the graph
            graph.addEdge(1, 2);
            graph.addEdge(1, 3);

//            }
            // Find shortest reach from node s
            int startId = 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
