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
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode u = q.poll();

            int target = k - u.val;

            if(bs(root, target, u)) return true;

            if(u.left != null) q.offer(u.left);
            if(u.right != null) q.offer(u.right);
        }

        return false;
    }

    boolean bs(TreeNode r, int t, TreeNode current){
        if(r == null) return false;

        if(r != current && r.val == t) return true;

        if(r.val < t) return bs(r.right, t, current);
        else if(r.val > t) return bs(r.left, t, current);

        return false;
    }
}