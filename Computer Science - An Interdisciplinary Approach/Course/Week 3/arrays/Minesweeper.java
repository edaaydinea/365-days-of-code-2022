/*
Minesweeper is a 1960s era video game played on an m-by-n grid of cells. T
he goal is to deduce which cells contain hidden mines using clues about the number of mines in
neighboring cells. Write a program Minesweeper.java that takes three integer command-line arguments m, n,
and k and prints an m-by-n grid of cells with k mines, using asterisks for mines and integers for the
neighboring mine counts (with two space characters between each cell).

To do so,
    - Generate an m-by-n grid of cells, with exactly k of the mn cells containing mines,
    uniformly at random.
    - For each cell not containing a mine, count the number of neighboring mines
    (above, below, left, right, or diagonal).
 */
public class Minesweeper
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] grid = new int[m][n];
        int[] mines = new int[k * 2];

        // Generate the coordinates of minus in the array
        int coordinate = 0;
        while (k * 2 > coordinate) {
            int a = (int) (Math.random() * m), b = (int) (Math.random() * n);
            if (grid[a][b] == 0) {
                grid[a][b] = -1;

                mines[coordinate] = a;
                mines[coordinate + 1] = b;
                coordinate += 2;
            }
        }

        // Increase the number of neighboring mines
        for (int i = 0; i < k * 2; i += 2) {
            for (int a = -1; a < 2; a++) {
                if (mines[i] + a >= 0 && mines[i] + a < m) {
                    for (int b = -1; b < 2; b++) {
                        if (mines[i + 1] + b >= 0 && mines[i + 1] + b < n && grid[mines[i] + a][mines[i + 1] + b] >= 0) {
                            grid[mines[i] + a][mines[i + 1] + b]++;
                        }
                    }
                }
            }
        }

        // Print the grid
        for (
                int i = 0;
                i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] >= 0) System.out.print(grid[i][j] + "  ");
                else System.out.print("*  ");
            }
            System.out.println();
        }
    }
}
