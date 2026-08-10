class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer>[] adj=new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        int[] indexing=new int[numCourses];
        for(int[] i:prerequisites){
            int p=i[0];
            int c=i[1];

            adj[p].add(c);
            indexing[c]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<indexing.length;i++){
            if(indexing[i]==0) q.offer(i);
        }

        Set<Integer>[] set=new HashSet[numCourses];

        for(int i=0;i<numCourses;i++){
            set[i]=new HashSet<>();
        }

        while(!q.isEmpty()){
            int u=q.poll();

            for(int v:adj[u]){
                set[v].add(u);

                set[v].addAll(set[u]);
                indexing[v]--;
                if(indexing[v]==0) q.offer(v);
            }
        }
        List<Boolean> ans=new ArrayList<>();

        for(int[] i:queries){
            int p=i[0];
            int c=i[1];

            ans.add(set[c].contains(p));
        }

        
        return ans;

    }
}