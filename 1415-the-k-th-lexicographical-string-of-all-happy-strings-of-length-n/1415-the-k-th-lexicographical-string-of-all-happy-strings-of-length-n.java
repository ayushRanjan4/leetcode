class Solution {

    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        dfs(n, k, new StringBuilder());
        return ans;
    }

    void dfs(int n, int k, StringBuilder curr) {

        if(curr.length() == n){
            count++;

            if(count == k){
                ans = curr.toString();
            }
            return;
        }

        for(char ch : new char[]{'a','b','c'}){

            if(curr.length() > 0 && curr.charAt(curr.length()-1) == ch)
                continue;

            curr.append(ch);

            dfs(n, k, curr);

            curr.deleteCharAt(curr.length()-1);

            if(!ans.equals(""))
                return;
        }
    }
}