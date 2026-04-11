/*
 * 874. Walking Robot Simulation
 */

import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Store obstacles in a HashSet for O(1) lookup
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }

        // Directions: North, East, South, West
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int dir = 0; // start facing North

        int x = 0, y = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4; // turn right
            } else if (cmd == -2) {
                dir = (dir + 3) % 4; // turn left
            } else {
                // move step by step
                for (int k = 0; k < cmd; k++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    if (set.contains(nx + "," + ny)) {
                        break; // obstacle hit
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}