class Solution {

    boolean dfs(int[][] graph,int curr,int[] color,int currColor){
        color[curr]=currColor;

        for(int v:graph[curr]){
            if(color[curr]==color[v]){
                return false;
            }
            if(color[v]==-1){
                int col=1-color[curr];
                if(dfs(graph,v,color,col)==false){
                    return false;
                }
            }
        }
        return true;
    }

    boolean bfs(int[][] adj,int i,int[] color,int currColor){
        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        color[i]=currColor;
        
        while(!q.isEmpty()){
            int u=q.poll();
            
            for(int v:adj[u]){
                if(color[u]==color[v]) return false;
                else if(color[v]==-1){
                    color[v]=1-color[u];
                    q.offer(v);
                }
            }
        }
        return true;
    }



    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(bfs(graph,i,color,1)==false){
                    return false;
                }
            }
        }
        return true;
    }
}