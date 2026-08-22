class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int i = 0;
        int j = len - k;
        while (i < j) {
            int mid = i + (j - i) / 2;

            if (x - arr[mid] > arr[mid + k] - x)
                i = mid + 1;
            else
                j = mid;
        }

        List<Integer> ans = new ArrayList<>();

        for (int a = i; a < i+k; a++) {
            ans.add(arr[a]);
        }

        return ans;
    }
}