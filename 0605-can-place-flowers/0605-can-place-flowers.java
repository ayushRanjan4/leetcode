class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int m) {
        int count=0;
        int n=flowerbed.length;
        if(n==1){
            if(m==1){
                return flowerbed[0]==0;
            }
        }
        for(int i=0;i<n-1;){
            if(flowerbed[i]==0){
                if(flowerbed[i]==flowerbed[i+1]){
                    flowerbed[i]=1;
                    count++;
                    i+=2;
                }else{
                    i++;
                }
            }else{
                i+=2;
            }
        }
        if(n>1 && flowerbed[n-1]==0){
            if(flowerbed[n-2]==flowerbed[n-1]) count++;
        }
        System.out.println(count);
        return count>=m;
    }
}