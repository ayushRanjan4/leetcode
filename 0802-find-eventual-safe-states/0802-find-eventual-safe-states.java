class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                adj[v].add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int u = q.poll();

            safe[u] = true;

            for (int v : adj[u]) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }
        return ans;

    }
}