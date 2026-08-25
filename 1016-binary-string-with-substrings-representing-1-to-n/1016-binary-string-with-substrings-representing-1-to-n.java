class Solution {
    public boolean queryString(String s, int n) {
        if (n > 1000)
            return false;
        int count = 0;
        boolean[] v = new boolean[n + 1];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                continue;
            int num=0;

            for (int j = i; j < s.length(); j++) {

                num = num * 2 + (s.charAt(j) - '0');

                if (num > n)
                    break;

                if (!v[num]) {
                    v[num] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
        return count == n;
    }
}