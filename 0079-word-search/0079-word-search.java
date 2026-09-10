class Solution {

    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    boolean dfs(char[][] board, boolean[][] vis, String word, int idx, int i, int j) {

        if (idx == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || vis[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }

        vis[i][j] = true;

        for (int[] d : dir) {
            if (dfs(board, vis, word, idx + 1, i + d[0], j + d[1])) {
                return true;
            }
        }

        vis[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, vis, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
