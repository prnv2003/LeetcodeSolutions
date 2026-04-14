/*
 * 3546. Equal Sum Grid Partition I
 */

class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        long totalSum = 0;
        long rowSum = 0;
        long colSum = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSum += grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum += grid[i][j];
            }

            if (rowSum == (totalSum - rowSum)) {
                return true;
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSum += grid[j][i];
            }

            if (colSum == (totalSum - colSum)) {
                return true;
            }

        }

        return false;

    }
}