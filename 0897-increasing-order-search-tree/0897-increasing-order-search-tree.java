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
    TreeNode ans=new TreeNode(0);
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head=ans;
        helper(root);
        return head.right;
    }
    void helper(TreeNode r){
        if(r==null) return;

        helper(r.left);

        ans.right=r;
        r.left=null;
        ans=ans.right;

        helper(r.right);
    }
}