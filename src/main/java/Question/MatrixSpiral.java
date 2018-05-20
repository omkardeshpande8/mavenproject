package Question;


class MatrixSpiral {

    static void spiralPrint(int a[][]) {
        int endRow = a.length;
        int endColumn = a[0].length;
        int startRow = 0, startColumn = 0;

        while (startRow < endRow && startColumn < endColumn) {
            // Print the first row from the remaining rows
            for (int i = startColumn; i < endColumn; ++i) {
                System.out.print(a[startRow][i] + " ");
            }
            startRow++;

            // Print the last column from the remaining columns 
            for (int i = startRow; i < endRow; ++i) {
                System.out.print(a[i][endColumn - 1] + " ");
            }
            endColumn--;

            // Print the last row from the remaining rows */
            if (startRow < endRow) {
                for (int i = endColumn - 1; i >= startColumn; --i) {
                    System.out.print(a[endRow - 1][i] + " ");
                }
                endRow--;
            }

            // Print the first column from the remaining columns */
            if (startColumn < endColumn) {
                for (int i = endRow - 1; i >= startRow; --i) {
                    System.out.print(a[i][startColumn] + " ");
                }
                startColumn++;
            }
        }
    }

    // driver program
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4, 5, 6},
        {7, 8, 9, 10, 11, 12},
        {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(a);
    }
}
