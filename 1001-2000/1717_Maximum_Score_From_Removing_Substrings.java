/*
 * 1717. Maximum Score From Removing Substrings
 */

class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            StringAndScore res1 = process(s, 'a', 'b', x);
            StringAndScore res2 = process(res1.str, 'b', 'a', y);
            return res1.score + res2.score;
        } else {
            StringAndScore res1 = process(s, 'b', 'a', y);
            StringAndScore res2 = process(res1.str, 'a', 'b', x);
            return res1.score + res2.score;
        }
    }

    private static class StringAndScore {
        String str;
        int score;

        StringAndScore(String str, int score) {
            this.str = str;
            this.score = score;
        }
    }

    private StringAndScore process(String s, char a, char b, int val) {
        StringBuilder stack = new StringBuilder();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == a && c == b) {
                stack.setLength(stack.length() - 1);
                score += val;
            } else {
                stack.append(c);
            }
        }
        return new StringAndScore(stack.toString(), score);
    }
}