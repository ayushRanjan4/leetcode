class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] depth = new int[n];
        Arrays.fill(depth, -1);
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1)
                continue;
            adj[parent[i]].add(i);
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                depth[i] = 1;
                q.offer(i);
            }
        }
        int len = 2;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int u = q.poll();

                for (int v : adj[u]) {
                    if (depth[v] == -1) {
                        depth[v]=len;
                        q.offer(v);
                    }
                }
            }
            len++;
        }
        int h=0;
        for(int i:depth) h=Math.max(h,i);

        long sum = 0;

        for (int i = 0; i < n; i++) {

            int d = depth[i];

            sum += (long) nums[i] * (h - d + 1);
        }
        return sum;
    }
}