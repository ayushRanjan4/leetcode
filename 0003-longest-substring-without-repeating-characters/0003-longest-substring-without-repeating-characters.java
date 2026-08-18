class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int[] arr=new int[128];

        int i=0;
        int j=0;
        int max=0;
        while(j<n){
            arr[s.charAt(j)]++;
            while(arr[s.charAt(j)]>1){
                arr[s.charAt(i)]--;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
        
    }
}