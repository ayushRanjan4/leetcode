class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str=new StringBuilder();
        for(String s:words){
            int sum=0;
            for(int j=0;j<s.length();j++){
                sum+=weights[s.charAt(j)-'a'];
            }
            int mod=sum%26;
            str.append((char)('z'-mod));
        }
        return str.toString();
    }
}