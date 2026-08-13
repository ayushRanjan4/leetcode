class Solution {
    public long maximumImportance(int n, int[][] roads) {

        int[] indegree=new int[n];

        for(int[] i:roads){
            int p=i[0];
            int c=i[1];
            indegree[p]++;
            indegree[c]++;
        }


        long sum=0L;

        Arrays.sort(indegree);

        for(int i=0;i<n;i++){
            sum+=(long)(i+1)*(long)(indegree[i]);
        }

        return sum;
    }
}