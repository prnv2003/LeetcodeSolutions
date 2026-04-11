/*
 * 2839. Check if Strings Can be Made Equal With Operations I
 */

class Solution {
    public boolean canBeEqual(String s1, String s2) {

        // check even index swap (0 & 2)
        boolean even = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // check odd index swap (1 & 3)
        boolean odd = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return even && odd;
    }
}