class Solution {
    public boolean checkOnesSegment(String s) {
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch=='1') count++;
        }
        int i=0;
        while(i<s.length() && s.charAt(i)=='1'){
            count--;
            i++;
        }
        return count==0;
    }
}