/*
 * 53. Maximum Subarray
 */

//Complexity = O(n^2)

class Solution {
    public int maxSubArray(int[] nums) {

        // To find the maximum sum possible
        int max_num = nums[0];

        // To store the maximum found at a position
        int curr_max_num = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // TO find the maximum sum along with 'i'
            curr_max_num = Math.max(nums[i], nums[i] + curr_max_num);

            // To compare 'max_num' & 'curr_max_num' to find the maximum sum/value
            max_num = Math.max(curr_max_num, max_num);

        }

        return max_num;

    }
}