class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] i: dislikes){
            int p=i[0];
            int c=i[1];
            adj[p].add(c);
            adj[c].add(p);
        }

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(bfs(adj,i,color,1)==false) return false;
            }
        }
        return true;
    }

    boolean bfs(ArrayList<Integer>[] adj,int i,int[] color,int curr){
        Queue<Integer> q=new LinkedList<>();

        q.offer(i);
        color[i]=curr;

        while(!q.isEmpty()){
            int u=q.poll();

            for(int v:adj[u]){
                if(color[v]==color[u]){
                    return false;
                }
                if(color[v]==-1){
                    color[v]=1-color[u];
                    q.offer(v);
                }
            }
        }
        return true;
    }
}