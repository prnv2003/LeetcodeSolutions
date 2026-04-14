/*
 * 3548. Equal Sum Grid Partition II
 */

import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        for (int[] row : grid)
            for (int v : row)
                total += v;

        // HORIZONTAL CUT
        long topSum = 0;
        Map<Integer, Integer> top = new HashMap<>();
        Map<Integer, Integer> bottom = new HashMap<>();

        for (int[] row : grid)
            for (int v : row)
                bottom.put(v, bottom.getOrDefault(v, 0) + 1);

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                top.put(v, top.getOrDefault(v, 0) + 1);
                bottom.put(v, bottom.get(v) - 1);
                if (bottom.get(v) == 0)
                    bottom.remove(v);
                topSum += v;
            }

            long bottomSum = total - topSum;
            if (topSum == bottomSum)
                return true;

            long diff = Math.abs(topSum - bottomSum);

            if (topSum > bottomSum) {
                if (check(top, grid, 0, i, 0, n - 1, diff))
                    return true;
            } else {
                if (check(bottom, grid, i + 1, m - 1, 0, n - 1, diff))
                    return true;
            }
        }

        // VERTICAL CUT
        long leftSum = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int[] row : grid)
            for (int v : row)
                right.put(v, right.getOrDefault(v, 0) + 1);

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int v = grid[i][j];
                left.put(v, left.getOrDefault(v, 0) + 1);
                right.put(v, right.get(v) - 1);
                if (right.get(v) == 0)
                    right.remove(v);
                leftSum += v;
            }

            long rightSum = total - leftSum;
            if (leftSum == rightSum)
                return true;

            long diff = Math.abs(leftSum - rightSum);

            if (leftSum > rightSum) {
                if (check(left, grid, 0, m - 1, 0, j, diff))
                    return true;
            } else {
                if (check(right, grid, 0, m - 1, j + 1, n - 1, diff))
                    return true;
            }
        }

        return false;
    }

    private boolean check(Map<Integer, Integer> freq, int[][] g,
            int r1, int r2, int c1, int c2, long diff) {

        // IMPORTANT: prevent overflow / invalid lookup
        if (diff > 100000 || !freq.containsKey((int) diff))
            return false;

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        // 2D block → always safe to remove any cell
        if (rows > 1 && cols > 1)
            return true;

        // 1D → must be endpoint inside section
        if (rows == 1) {
            return g[r1][c1] == diff || g[r1][c2] == diff;
        } else {
            return g[r1][c1] == diff || g[r2][c1] == diff;
        }
    }
}