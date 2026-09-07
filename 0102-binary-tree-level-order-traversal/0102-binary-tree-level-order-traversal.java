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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            List<Integer> inner=new ArrayList<>();

            int size=q.size();
            while(size-->0){
                TreeNode u=q.poll();
                
                inner.add(u.val);
                
                if(u.left!=null){
                    q.offer(u.left);
                }
                if(u.right!=null){
                    q.offer(u.right);
                }
            }
            ans.add(inner);
        }

        return ans;
    }
}