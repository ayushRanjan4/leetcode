class Solution {
    public void sortColors(int[] nums) {
        int z_count=0;
        int o_count=0;
        int t_count=0;
        for(int i:nums){
            if(i==0)z_count++;
            else if(i==1)o_count++;
            else t_count++;
        }
        int j=0;
        for(int i=0;i<z_count;i++){
            nums[j]=0;
            j++;
        }
        for(int i=0;i<o_count;i++){
            nums[j]=1;
            j++;
        }
        for(int i=0;i<t_count;i++){
            nums[j]=2;
            j++;
        }
    }
}