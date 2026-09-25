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
 /**
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode u=q.poll();
            if(u.val==val) return u;
            if(u.left!=null) q.offer(u.left);
            if(u.right!=null) q.offer(u.right);
        }
        return null;
    }
}
*/
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val)
            return root;
        if(val<root.val){
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }
}