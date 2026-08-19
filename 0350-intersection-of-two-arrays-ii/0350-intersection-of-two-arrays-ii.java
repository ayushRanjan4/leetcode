class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans=new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n=nums1.length;

        int m=nums2.length;

        int i=0;
        int j=0;

        while(i<n && j<m){
            if(nums1[i]==nums2[j]){
                ans.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]) j++;
            else i++;
        }

        int[] result=new int[ans.size()];
        for(int z=0;z<ans.size();z++){
            result[z]=ans.get(z);
        }
        return result;
    }
}