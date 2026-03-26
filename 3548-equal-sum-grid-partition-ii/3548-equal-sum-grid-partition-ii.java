class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        HashMap<Long,Integer> top = new HashMap<>();
        HashMap<Long,Integer> bottom = new HashMap<>();

        HashMap<Long,Integer> left = new HashMap<>();
        HashMap<Long,Integer> right = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j];
                total += val;
                bottom.put(
                    (long)val,
                    bottom.getOrDefault((long)val,0)+1
                );

                right.put(
                    (long)val,
                    right.getOrDefault((long)val,0)+1
                );
            }
        }


        long sumTop = 0;

        for(int i=0;i<m-1;i++){

       
            for(int j=0;j<n;j++){

                long val = grid[i][j];
                sumTop += val;

                top.put(
                    val,
                    top.getOrDefault(val,0)+1
                );

                bottom.put(
                    val,
                    bottom.get(val)-1
                );

                if(bottom.get(val)==0)
                    bottom.remove(val);
            }

            long sumBottom = total - sumTop;

            if(sumTop == sumBottom)
                return true;

            long diff = Math.abs(sumTop - sumBottom);

            if(sumTop > sumBottom){

                // remove from TOP
                if(check(top,grid,0, i,0, n-1,diff))return true;

            }else{
                // remove from BOTTOM
                if(check(bottom, grid,i+1, m-1,0, n-1,diff))return true;
            }
        }


        long sumLeft = 0;

        for(int j=0;j<n-1;j++){

            for(int i=0;i<m;i++){

                long val = grid[i][j];

                sumLeft += val;

                left.put(
                    val,
                    left.getOrDefault(val,0)+1
                );

                right.put(
                    val,
                    right.get(val)-1
                );

                if(right.get(val)==0)
                    right.remove(val);
            }

            long sumRight =
                total - sumLeft;

            if(sumLeft == sumRight)
                return true;

            long diff =
                Math.abs(sumLeft - sumRight);

            if(sumLeft > sumRight){

                if(check(left,grid,0, m-1,0, j,diff))return true;

            }else{

                if(check(right,grid,0, m-1,j+1, n-1,diff))return true;
            }
        }

        return false;
    }

    private boolean check(
        HashMap<Long,Integer> map,
        int[][] grid,
        int r1, int r2,
        int c1, int c2,
        long diff
    ){

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        if(rows * cols == 1)
            return false;

        if(rows == 1){
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }

        if(cols == 1){
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }

        return map.getOrDefault(diff,0) > 0;
    }
}