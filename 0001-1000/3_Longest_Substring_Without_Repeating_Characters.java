/*
 * 3. Longest Substring Without Repeating Characters
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] ns = new boolean[128];

        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            while (ns[c]) {
                ns[s.charAt(i++)] = false;
            }
            ns[c] = true;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}