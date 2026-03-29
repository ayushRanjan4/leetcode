class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr=new int[3];
        int left=0;
        int right=0;
        int count=0;
        while(right<s.length()){
            arr[s.charAt(right)-'a']++;
            while(check(arr)){
                count+=s.length()-right;
                arr[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
    boolean check(int[] arr){
        for(int i:arr){
           if(i<1) return false; 
        }
        return true;
    }
}