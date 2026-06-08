// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         ArrayList<Integer> sm=new ArrayList<>();
//         ArrayList<Integer> lr=new ArrayList<>();
//         int count=0;
//         for(int i:nums){
//             if(i<pivot) sm.add(i);
//             else if (i== pivot) count++;
//             else lr.add(i);
//         }
//         while(count-- >0){
//             sm.add(pivot);
//         }
//         int i=0;
//         for(int j:sm){
//             nums[i++]=j;
//         }
//         for(int j:lr){
//             nums[i++]=j;
//         }
//         return nums;

//     }
// }
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr=new int[nums.length];
        int j=0;
        int count=0;
        for(int i: nums){
            if(i<pivot) arr[j++]=i;
            if(i==pivot) count++;
        }
        while(count-- >0){
            arr[j++]=pivot;
        }
        for(int i: nums){
            if(i>pivot) arr[j++]=i;
        }
        return arr;
    }
}
