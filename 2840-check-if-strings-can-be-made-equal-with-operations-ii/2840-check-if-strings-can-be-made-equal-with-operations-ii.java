class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] s1o=new int[27];
        int[] s1e=new int[27];
        
        for(int i=1;i<s1.length();i+=2){
            s1o[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s1.length();i+=2){
            s1e[s1.charAt(i)-'a']++;
        }


        int[] s2o=new int[27];
        int[] s2e=new int[27];

        for(int i=1;i<s2.length();i+=2){
            s2o[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length();i+=2){
            s2e[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<27;i++){
            if(s1o[i]!=s2o[i]) return false;
        }

        for(int i=0;i<27;i++){
            if(s1e[i]!=s2e[i]) return false;
        }
        return true;
    }
}