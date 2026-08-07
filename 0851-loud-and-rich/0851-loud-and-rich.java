class Solution {
    int[] parent;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] indegree = new int[n];
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] i : richer) {
            int p = i[0];
            int c = i[1];
            adj[p].add(c);
            indegree[c]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i]==0)q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj[u]) {
                if (quiet[parent[v]] > quiet[parent[u]]) {
                    parent[v] = parent[u];
                }
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return parent;
    }
}