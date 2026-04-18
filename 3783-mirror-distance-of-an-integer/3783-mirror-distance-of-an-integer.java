class Solution {
    public int mirrorDistance(int n) {
        int org=n;
        int num=0;
        while(n>0){
            int num1=n%10;
            num=num*10+num1;
            n=n/10;
        }
        return Math.abs(org-num);
    }
}