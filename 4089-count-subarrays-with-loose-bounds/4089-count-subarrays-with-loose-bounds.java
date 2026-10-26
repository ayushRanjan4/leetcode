class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int j=0;
        long total=0;
        long count=0;
        while(j<nums.length){
            if(nums[j]>=minK && nums[j]<=maxK){
                count++;
                total+=count;
            }else{
                count=0;
            }
            j++;

        }
        return total;
    }
}