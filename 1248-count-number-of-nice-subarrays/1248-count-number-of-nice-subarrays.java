class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left=0;
        int right=0;
        int count=0;
        int odd=0;

        while(right<nums.length){
            if(nums[right]%2==1){
                odd++;
            }

            while(odd>k){
                if(nums[left]%2==1) odd--;
                left++;
            }

            if(odd==k) count++;

            int temp=left;

            while(odd==k && temp<right && nums[temp]%2==0){
                count++;
                temp++;
            }

            right++;
        }
        return count++;
    }
}