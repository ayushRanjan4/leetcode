class Solution {
    public int maxSatisfied(int[] c, int[] g, int m) {
        int total=0;
        int n=c.length;
        for(int i=0;i<n;i++){
            if(g[i]==0){
                total+=c[i];
            }
        }
        int i=0;
        int j=0;
        int t=0;
        int max=0;
        while(j<n){
            if(g[j]==1){
                t+=c[j];
            }
            while(j-i+1>m){
                if(g[i]==1){
                    t-=c[i];
                }
                i++;
            }
            max=Math.max(max,total+t);
            j++;
        }
        return max;
    }
}