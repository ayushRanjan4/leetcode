class Solution {
    public int maxDepth(String s) {
        int max=0;
        int cnt=0;
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
                cnt++;
            }
            if(s.charAt(i)==')' && !st.isEmpty()){
                max=Math.max(max,cnt);
                cnt--;
                st.pop();
            }
            i++;
        }
        return max;
    }
}