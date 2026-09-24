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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Double sum=0d;
            int size=q.size();
            int s=size;
            while(size-->0){
                TreeNode u=q.poll(); 
                sum+=(double)u.val;
                if(u.left!=null) q.offer(u.left);
                if(u.right!=null) q.offer(u.right);
            }
            list.add(sum/(double)s);
        }
        return list;
    }
}