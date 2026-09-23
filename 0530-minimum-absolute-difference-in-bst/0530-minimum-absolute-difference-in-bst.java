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
    ArrayList<Integer> list;
    int perv=-1;
    int min;
    void inoder(TreeNode root){
        if(root==null) return;

        inoder(root.left);
        if(perv!=-1){
            min=Math.min(min,Math.abs(root.val-perv));
            perv=root.val;
        }else{
            perv=root.val;
        }
        inoder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        // list=new ArrayList<>();
        min=Integer.MAX_VALUE;
        inoder(root);
        
        // for(int i=0;i<list.size()-1;i++)
        // {
        //     min=Math.min(min,Math.abs(list.get(i)-list.get(i+1)));
        // }
        return min;
    }
}