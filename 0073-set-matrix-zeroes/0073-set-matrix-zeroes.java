class Solution {
    public void setZeroes(int[][] matrix) {
        int[] arrC = new int[matrix[0].length];
        Arrays.fill(arrC, 1);

        int[] arrR = new int[matrix.length];
        Arrays.fill(arrR, 1);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    arrC[j] = 0;
                    arrR[i] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(arrR[i] == 0 || arrC[j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}