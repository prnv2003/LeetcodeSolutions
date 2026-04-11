/*
 * 2840. Check if Strings Can be Made Equal With Operations II
 */

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] hashE = new int[26];
        int[] hashO = new int[26];

        int n = s1.length();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                hashE[s1.charAt(i) - 'a']++;
            } else {
                hashO[s1.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                hashE[s2.charAt(i) - 'a']--;
            } else {
                hashO[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (hashE[i] != 0 || hashO[i] != 0) {
                return false;
            }
        }

        return true;

    }
}