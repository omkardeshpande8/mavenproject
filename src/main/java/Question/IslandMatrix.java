package Question;

import java.util.AbstractMap;

/**
 *
 * @author omkar
 */
public class IslandMatrix {

//    private static void markIsland(int[][] matrix, int row, int column) {
//
//        matrix[row][column] = -1;
//        for (int r = row - 1; r <= row + 1; r++) {
//            for (int c = column - 1; c <= column + 1; c++) {
//                if (!(r == row && c == column) && r >= 0 && c >= 0 && r < matrix.length && c < matrix[row].length && matrix[r][c] > 0) {
//                    markIsland(matrix, r, c);
//                }
//            }
//        }
//    }
//
//    public static int getNumberOfIslands(int[][] matrix) {
//        int count = 0;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int column = 0; column < matrix[row].length; column++) {
//                if (matrix[row][column] == 1) {
//                    markIsland(matrix, row, column);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    private static int getSize(int[][] matrix, int row, int column) {
        int size = 1;
        matrix[row][column] = -1;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (!(r == row && c == column) && r >= 0 && c >= 0 && r < matrix.length && c < matrix[row].length && matrix[r][c] > 0) {
                    size += getSize(matrix, r, c);
                }
            }
        }
        return size;
    }

    public static AbstractMap.SimpleEntry<Integer, Integer> getLargestIsland(int[][] matrix) {
        int size = 0;
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    int temp = getSize(matrix, row, column);
                    size = Math.max(size, temp);
                    count++;
                }
            }
        }
        return new AbstractMap.SimpleEntry<>(size, count);
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}};
//        int numberOfIslands = getNumberOfIslands(mat);
//        System.out.println(numberOfIslands);
        AbstractMap.SimpleEntry<Integer, Integer> result = getLargestIsland(mat);

        System.out.println(result.getKey());
        System.out.println(result.getValue());
    }

}
