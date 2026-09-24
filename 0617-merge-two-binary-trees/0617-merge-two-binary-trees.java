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
*/
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode[]> queue = new LinkedList<>();

        queue.offer(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {

            TreeNode[] pair = queue.poll();

            TreeNode r1 = pair[0];
            TreeNode r2 = pair[1];

            r1.val += r2.val;
            if (r1.left == null) {
                r1.left = r2.left;
            } 
            else if (r2.left != null) {
                queue.offer(new TreeNode[]{r1.left, r2.left});
            }
            if (r1.right == null) {
                r1.right = r2.right;
            } 
            else if (r2.right != null) {
                queue.offer(new TreeNode[]{r1.right, r2.right});
            }
        }

        return root1;
    }
}