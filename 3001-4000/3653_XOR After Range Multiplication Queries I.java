
/*
 * 3653. XOR After Range Multiplication Queries I
 */

// import java.util.*;

class Solution {
    int mod = 1000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {

        for (int q[] : queries) {

            int idx = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            while (idx <= r) {
                long curr = nums[idx];
                curr = (curr * v) % mod;
                nums[idx] = (int) curr;
                idx += k;
            }
        }

        int xor = 0;
        for (int num : nums) {
            xor = (xor ^ num);
        }

        return xor;

    }
}