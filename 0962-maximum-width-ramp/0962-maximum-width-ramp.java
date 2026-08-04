class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        int[] min = new int[n];
        int[] max = new int[n];

        min[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[min[i - 1]]) {
                min[i] = i;
            } else {
                min[i] = min[i - 1];
            }
        }
        max[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[max[i + 1]]) {
                max[i] = i;
            } else {
                max[i] = max[i + 1];
            }
        }

        int i = 0, j = 0;
        int ans = 0;

        while (i < n && j < n) {
            if (nums[min[i]] <= nums[max[j]]) {
                ans = Math.max(ans, max[j] - min[i]);
                j++;
            } else {
                i++;
            }
        }

        return ans;
    }
}