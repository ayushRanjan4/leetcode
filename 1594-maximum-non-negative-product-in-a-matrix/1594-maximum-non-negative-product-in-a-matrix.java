class Solution {
    public int maxProductPath(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        long[][] maxi=new long[n][m];
        long[][] mini=new long[n][m];
        maxi[0][0]=grid[0][0];
        mini[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            maxi[0][i]=maxi[0][i-1]*grid[0][i];
            mini[0][i]=mini[0][i-1]*grid[0][i];
        }

        for(int i=1;i<n;i++){
            mini[i][0]=mini[i-1][0]*grid[i][0];
            maxi[i][0]=maxi[i-1][0]*grid[i][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int curr=grid[i][j];
                long max=Math.max(maxi[i-1][j]*curr,maxi[i][j-1]*curr);
                max=Math.max(mini[i-1][j]*curr,max);
                max=Math.max(max,mini[i][j-1]*curr);

                long min=Math.min(maxi[i-1][j]*curr,maxi[i][j-1]*curr);
                min=Math.min(mini[i-1][j]*curr,min);
                min=Math.min(min,mini[i][j-1]*curr);

                maxi[i][j]=max;
                mini[i][j]=min;
            }
        }

        long ans=maxi[n-1][m-1];
        if(ans<0)return -1;
        return (int)(ans%1000000007L);
    }
}