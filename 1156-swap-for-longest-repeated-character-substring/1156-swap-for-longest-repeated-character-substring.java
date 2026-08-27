class Solution {
    public int maxRepOpt1(String t) {
        int max = 0;

        Set<Character> set = new HashSet<>();
        for (char ch : t.toCharArray()) {
            set.add(ch);
        }

        for (char ch : set) {

            int total = 0;
            for (char c : t.toCharArray()) {
                if (c == ch) total++;
            }

            int i = 0;
            int count = 0;
            int other = 0;

            for (int j = 0; j < t.length(); j++) {

                if (t.charAt(j) == ch) {
                    count++;
                } else {
                    other++;
                }

                while (other > 1) {
                    if (t.charAt(i) == ch) {
                        count--;
                    } else {
                        other--;
                    }
                    i++;
                }

                max = Math.max(max, Math.min(j - i + 1, total));
            }
        }

        return max;
    }
}