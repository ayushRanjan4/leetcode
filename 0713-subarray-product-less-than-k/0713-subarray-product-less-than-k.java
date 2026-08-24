class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0;
        int i=0;
        int j=0;
        int prt=1;

        while(j<nums.length){
            prt*=nums[j];
            while(prt>=k && i<=j){
                prt/=nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}