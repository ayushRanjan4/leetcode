class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sort(strs[i]);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(strs[i]);
        }
        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;
    }

    String sort(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                str.append(String.valueOf((char) ('a' + i)).repeat(freq[i]));
            }
        }
        return str.toString();
    }
}