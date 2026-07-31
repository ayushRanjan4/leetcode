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

    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];

        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(String str:equations){
            if(str.charAt(1)=='='){
                union(str.charAt(0)-'a',str.charAt(3)-'a');
            }
        }

        for(String str:equations){
            if(str.charAt(1)=='!'){
                int first=find(str.charAt(0)-'a');
                int second=find(str.charAt(3)-'a');

                if(first==second){
                    return false;
                }
            }
        }
        return true;

    }
}