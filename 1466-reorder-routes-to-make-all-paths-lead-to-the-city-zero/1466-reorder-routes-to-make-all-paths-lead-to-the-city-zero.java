class Solution {

    int count=0;

    void dfs(int node,int par,ArrayList<int[]>[] adj){
        for(int[] i:adj[node]){
            int v=i[0];
            int dir=i[1];

            if(v!=par){
                if(dir==0) count++;
                dfs(v,node,adj);
            }
        }
    }


    public int minReorder(int n, int[][] connections) {


        ArrayList<int[]>[] adj=new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();

        }
        int[] indegree=new int[n];

        for(int[] i:connections){
            int p=i[0];
            int c=i[1];

            adj[p].add(new int[]{c,0});
            adj[c].add(new int[]{p,1});
        }
        
        dfs(0,-1,adj);
        return count;

        
    }
}