class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int[] arr = new int[128];
        int[] arr1 = new int[128];
        for (int i = 0; i < t.length(); i++) {
            arr1[t.charAt(i)]++;
        }
        int min = Integer.MAX_VALUE;
        String str = "";

        while (right < s.length()) {
            arr[s.charAt(right)]++;
            while (check(arr, arr1, t)) {
                if (min > right - left + 1) {
                    str = s.substring(left, right + 1);
                    min = Math.min(min, right - left + 1);
                }
                arr[s.charAt(left)]--;
                left++;
            }
            right++;
        }
        return str;
    }

    boolean check(int[] arr, int[] arr1, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (arr[c] < arr1[c])
                return false;
        }
        return true;
    }
}