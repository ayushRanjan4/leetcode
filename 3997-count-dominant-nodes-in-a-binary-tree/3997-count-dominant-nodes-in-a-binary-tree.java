/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;

    public int countDominantNodes(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }

    int helper(TreeNode r) {
        if (r == null) return Integer.MIN_VALUE;

        int left = helper(r.left);
        int right = helper(r.right);

        int max = Math.max(r.val, Math.max(left, right));

        if (r.val == max) {
            count++;
        }

        return max;
    }
}