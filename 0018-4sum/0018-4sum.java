class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int l=j+1;
                int k=nums.length-1;
                while(l<k){
                    long total = (long) nums[i] + nums[j] + nums[l] + nums[k];

                    if (total > target) {
                        k--;
                    }
                    else if (total < target) {
                        l++;
                    }
                    else {
                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[l],
                            nums[k]
                        ));

                        l++;
                        k--;

                        while (l < k && nums[l] == nums[l - 1])
                            l++;

                        while (l < k && nums[k] == nums[k + 1])
                            k--;
                    }
                }
            }
        }
        return ans;
    }
}