class Solution {
    int[] dp;

    int solve(int[] nums, int idx) {
        if (idx >= nums.length - 1) return 0;
        if (dp[idx] != -1) return dp[idx];
        if (nums[idx] == 0) return dp[idx] = Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx] && idx + i < nums.length; i++) {
            int next = solve(nums, idx + i);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + next);
            }
        }
        return dp[idx] = min;
    }

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
}
