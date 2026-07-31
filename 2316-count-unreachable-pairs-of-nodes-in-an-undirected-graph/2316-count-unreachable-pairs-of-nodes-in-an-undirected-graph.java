class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    void union(int x,int y){

        int parent_x=find(x);
        int parent_y=find(y);

        if(rank[parent_x]>rank[parent_y]){
            parent[parent_y]=parent_x;
        }else if(rank[parent_x]<rank[parent_y]){
            parent[parent_x]=parent_y;
        }else{
            parent[parent_x]=parent_y;
            rank[parent_y]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        parent=new int[n];
        rank=new int[n];
        int[] map=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            union(u,v);
        }

        for(int i=0;i<n;i++){
            int parent_i=find(i);
            map[parent_i]++;
        }
        long result=0;
        long rem=n;
        for(int i:map){
            result+=i*(rem-i);
            rem-=i;
        }

        return result;



    }
}