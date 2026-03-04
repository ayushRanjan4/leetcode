class Solution {
    public int numSpecial(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int result = 0;

        for(int i = 0; i < m; i++) {

            int rowCount = 0;
            int colIndex = -1;

            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    rowCount++;
                    colIndex = j;
                }
            }

            if(rowCount == 1) {

                int colCount = 0;

                for(int k = 0; k < m; k++) {
                    if(mat[k][colIndex] == 1)
                        colCount++;
                }

                if(colCount == 1)
                    result++;
            }
        }

        return result;
    }
}