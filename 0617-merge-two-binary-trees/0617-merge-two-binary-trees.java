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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return solve(root1,root2);
    }
    TreeNode solve(TreeNode r1,TreeNode r2){
        if(r1==null && r2==null) return null;

        int left=r1!=null?r1.val:0;
        int right=r2!=null?r2.val:0;
        TreeNode root=new TreeNode(left+right);
        root.left = solve(
            r1 != null ? r1.left : null,
            r2 != null ? r2.left : null
        );

        root.right = solve(
            r1 != null ? r1.right : null,
            r2 != null ? r2.right : null
        );
        return root;
    }
}