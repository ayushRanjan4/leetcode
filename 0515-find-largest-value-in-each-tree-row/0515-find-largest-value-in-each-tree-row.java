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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ans;
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();

            int max=Integer.MIN_VALUE;
            while(size-->0){
                TreeNode u=q.poll();

                max=Math.max(max,u.val);

                if(u.left!=null) q.offer(u.left);
                if(u.right!=null) q.offer(u.right);

            }
            ans.add(max);
        }

        return ans;
    }
}