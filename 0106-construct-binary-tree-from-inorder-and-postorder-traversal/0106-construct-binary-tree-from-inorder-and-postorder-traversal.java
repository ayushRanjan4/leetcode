
class Solution {
    public TreeNode buildTree(int[] in, int[] post) {
        int i = 0;
        int j = in.length - 1;
        int z = post.length - 1;

        return helper(i, j, z, in, post);
    }

    TreeNode helper(int i, int j, int z, int[] in, int[] post) {
        if (i > j) {
            return null;
        }

        TreeNode root = new TreeNode(post[z]);

        int a = i;
        for (; a <= j; a++) {
            if (post[z] == in[a]) {
                break;
            }
        }

        root.left = helper(i, a - 1, z - (j - a) - 1, in, post);
        root.right = helper(a + 1, j, z - 1, in, post);

        return root;
    }
}
