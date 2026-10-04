class Solution {
    public int longestValidParentheses(String s) {

        int o = 0;
        int c = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(')
                o++;
            else
                c++;

            if (o == c) {
                max = Math.max(max, 2 * c);
            }

            if (c > o) {
                o = 0;
                c = 0;
            }
        }

        o = 0;
        c = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(')
                o++;
            else
                c++;

            if (o == c) {
                max = Math.max(max, 2 * o);
            }

            if (o > c) {
                o = 0;
                c = 0;
            }
        }

        return max;
    }
}