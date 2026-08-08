class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 0 = red, 1 = blue
        for (int[] i : redEdges) {
            int p = i[0];
            int c = i[1];
            adj[p].add(new int[]{c, 0});
        }

        for (int[] i : blueEdges) {
            int p = i[0];
            int c = i[1];
            adj[p].add(new int[]{c, 1});
        }

        int[] edge = new int[n];
        Arrays.fill(edge, -1);
        edge[0] = 0;

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] x = q.poll();

                int u = x[0];
                int prevColor = x[1];

                for (int[] v : adj[u]) {

                    int next = v[0];
                    int color = v[1];

                    if (color == prevColor) {
                        continue;
                    }

                    if (visited[next][color]) {
                        continue;
                    }

                    visited[next][color] = true;

                    if (edge[next] == -1) {
                        edge[next] = distance + 1;
                    }

                    q.offer(new int[]{next, color});
                }
            }

            distance++;
        }

        return edge;
    }
}