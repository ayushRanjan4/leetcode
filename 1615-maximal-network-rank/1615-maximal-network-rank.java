class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int count = 0;

        for (int p = 0; p < n; p++) {
            for (int c = p + 1; c < n; c++) {

                int rank = adj[p].size() + adj[c].size();

                if (adj[p].contains(c)) {
                    rank--;
                }

                count = Math.max(count, rank);
            }
        }

        return count;
    }
}