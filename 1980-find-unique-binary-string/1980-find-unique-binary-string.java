class Solution {
    ArrayList<String> ans;

    void solve(int n, StringBuilder str) {
        if (str.length() == n) {
            ans.add(str.toString());
            return;
        }

        str.append('1');
        solve(n, str);
        str.deleteCharAt(str.length() - 1);

        str.append('0');
        solve(n, str);
        str.deleteCharAt(str.length() - 1);
    }

    public String findDifferentBinaryString(String[] nums) {
        ans = new ArrayList<>();
        int n = nums[0].length();

        solve(n, new StringBuilder());

        Arrays.sort(nums);
        Collections.sort(ans);

        for (int i = 0; i < nums.length; i++) {
            if (!nums[i].equals(ans.get(i))) {
                return ans.get(i);
            }
        }

        return ans.get(nums.length); // fix
    }
}