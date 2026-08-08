class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : paths) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            boolean[] used = new boolean[5];

            for (int v : adj[i]) {
                used[color[v]] = true;
            }

            for (int c = 1; c <= 4; c++) {
                if (!used[c]) {
                    color[i] = c;
                    break;
                }
            }
        }

        return Arrays.copyOfRange(color, 1, n + 1);
    }
}