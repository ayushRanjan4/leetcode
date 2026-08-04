class Solution {

    List<List<Integer>> outer;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        outer = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(0);
        dfs(inner, 0, graph);
        return outer;

    }

    void dfs(ArrayList<Integer> inner, int u, int[][] graph) {
        if (u == graph.length - 1) {
            outer.add(new ArrayList<>(inner));
            return;
        }

        for (int v : graph[u]) {
            inner.add(v);
            dfs(inner, v, graph);
            inner.remove(inner.size() - 1);
        }
    }
}