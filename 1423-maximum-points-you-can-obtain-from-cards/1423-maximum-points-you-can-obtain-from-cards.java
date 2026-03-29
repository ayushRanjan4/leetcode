class Solution {
    public int maxScore(int[] arr, int k) {
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += arr[i];
        }
        int max = total;
        for (int i = 0; i < k; i++) {
            total -= arr[k - i - 1];

            total += arr[arr.length - i - 1];

            max = Math.max(total, max);
        }
        return max;
    }
}