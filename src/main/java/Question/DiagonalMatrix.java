package Question;

import java.util.LinkedList;
import scala.Tuple2;

/**
 *
 * @author Omkar
 */
public class DiagonalMatrix {

    private static void diagonalOrder(int[][] M) {
        int rowCount = M.length;
        int columnCount = M[0].length;
        LinkedList<Tuple2<Integer, Integer>> ll = new LinkedList<>();
        ll.offer(new Tuple2<>(0, 0));

        while (!ll.isEmpty()) {
            Tuple2<Integer, Integer> point = ll.poll();
            System.out.print(M[point._1][point._2] + "  ");
            if (point._1 + 1 < rowCount) {
                Tuple2<Integer, Integer> point1 = new Tuple2<>(point._1 + 1, point._2);
                if (ll.isEmpty() || !ll.peekLast().equals(point1)) {
                    ll.offer(point1);
                }
            }
            if (point._2 + 1 < columnCount) {
                Tuple2<Integer, Integer> point2 = new Tuple2<>(point._1, point._2 + 1);
                ll.offer(point2);
            }
        }
    }

    public static void main(String[] args) {
        int M[][] = {
            {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
            {13, 14, 15, 16}, {17, 18, 19, 20},};

        System.out.print("\nDiagonal printing of matrix is \n");
        diagonalOrder(M);
    }

}
