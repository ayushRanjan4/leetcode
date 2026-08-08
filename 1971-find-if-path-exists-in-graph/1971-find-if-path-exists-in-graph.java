class Solution {
    int[] rank;
    int[] parent;

    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    void union(int x,int y){
        int parent_x=find(x);
        int parent_y=find(y);
        if(parent_x==parent_y) return;
        if(rank[parent_x]>rank[parent_y]){
            parent[parent_y]=parent_x;
        }else if(rank[parent_x]<rank[parent_y]){
            parent[parent_x]=parent_y;
        }else{
            parent[parent_x]=parent_y;
            rank[parent_y]++;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Integer>[] adj=new ArrayList[n];
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] i:edges){
            int p=i[0];
            int c=i[1];
            union(p,c);
        }

        return find(source)==find(destination);


    }
}