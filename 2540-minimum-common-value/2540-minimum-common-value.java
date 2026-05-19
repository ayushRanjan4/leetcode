class Solution {
    public int getCommon(int[] arr1, int[] arr2) {
        int left=0;
        int right=0;
        while(left<arr1.length && right<arr2.length){
            if(arr1[left]==arr2[right]){
                return arr1[left];
            }else if(arr1[left]>arr2[right]){
                right++;
            }else{
                left++;
            }
        }
        return -1;
    }
}