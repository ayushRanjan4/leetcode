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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
        if(root==null) return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean flag=true; //true-->left to right & false-->right to left
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> inner=new ArrayList<>();
            while(size-->0){
                TreeNode u=q.poll();
                inner.add(u.val);
                if(u.left!=null) q.offer(u.left);
                if(u.right!=null) q.offer(u.right);
            }
            if(flag){
                l.add(inner);
                flag=false;
            }
            else if(!flag){
                Collections.reverse(inner);
                l.add(inner);
                flag=true;
            }
        }
        return l;
    }
}