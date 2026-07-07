class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Boolean[] flag = new Boolean[n];
        Arrays.fill(flag, false);
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            for (int j = i + 1; j < n; j++) {
                int c = intervals[j][0];
                int d = intervals[j][1];
                if (c <= a && b <= d) {
                    count++;
                    flag[i] = true;
                    break;
                }
            }
        }
        int count1 = 0;
        for (int i = n - 1; i > 0; i--) {
            if (!flag[i]) {
                int a = intervals[i][0];
                int b = intervals[i][1];
                for (int j = i - 1; j >= 0; j--) {
                    int c = intervals[j][0];
                    int d = intervals[j][1];
                    if (c <= a && b <= d && !flag[j]) {
                        count1++;
                        break;
                    }

                }
            }
        }
        return n - (count + count1);
    }
}