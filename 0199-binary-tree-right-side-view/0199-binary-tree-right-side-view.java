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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            int v=-1;

            while(size-->0){
                TreeNode u=q.poll();
                v=u.val;
                if(u.left!=null) q.offer(u.left);
                if(u.right!=null) q.offer(u.right);
            }
            ans.add(v);
        }
        return ans;
    }
}
  */
class Solution {
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans=new ArrayList<>();
        dfs(root,1);
        return ans;
    }
    void dfs(TreeNode r,int l){
        if(r==null) return;
        if(l>ans.size()){
            ans.add(r.val);
        }
        dfs(r.right,l+1);
        dfs(r.left,l+1);
    }
}