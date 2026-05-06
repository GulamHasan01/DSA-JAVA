package Arrays;

public class RotateBox {
    public char[][] rotateTheBox(char[][] boxGrid) {

        int m = boxGrid.length;
        int n = boxGrid[0].length;

        //gravity
        for (int row = 0; row < m; row++) {

            int pointer = n - 1;

            for (int col = n - 1; col >= 0; col--) {

                if (boxGrid[row][col] == '*') {

                    pointer = col - 1;

                } else if (boxGrid[row][col] == '#') {

                    boxGrid[row][col] = '.';
                    boxGrid[row][pointer] = '#';

                    pointer--;
                }
            }
        }

        //Rotate
        char[][] newGrid = new char[n][m];

        for (int row = 0; row < m; row++) {

            for (int col = 0; col < n; col++) {

                newGrid[col][m - 1 - row] = boxGrid[row][col];
            }
        }

        return newGrid;
    }
}
