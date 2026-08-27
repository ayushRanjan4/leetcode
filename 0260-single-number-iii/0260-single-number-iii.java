class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums){
            xor^=i;
        }

        int mask=xor & -xor;

        int a=0;
        int b=0;

        for(int i:nums){
            if((i&mask)!=0){
                a^=i;
            }else b^= i;
        }

        return new int[]{a,b};
    }
}