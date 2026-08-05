class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return false;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
        return true;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        parent = new int[n];
        rank = new int[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {

            if (leftChild[i] != -1) {
                int child = leftChild[i];

                indegree[child]++;
                if (indegree[child] > 1)
                    return false;

                if (!union(i, child))
                    return false;
            }

            if (rightChild[i] != -1) {
                int child = rightChild[i];

                indegree[child]++;
                if (indegree[child] > 1)
                    return false;

                if (!union(i, child))
                    return false;
            }
        }

        int roots = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                roots++;
        }

        if (roots != 1)
            return false;

        int root = find(0);
        for (int i = 1; i < n; i++) {
            if (find(i) != root)
                return false;
        }

        return true;
    }
}