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
// class Solution {
//     public boolean leafSimilar(TreeNode root1, TreeNode root2) {

//         Stack<TreeNode> s1 = new Stack<>();
//         Stack<TreeNode> s2 = new Stack<>();

//         s1.push(root1);
//         s2.push(root2);

//         while (!s1.isEmpty() && !s2.isEmpty()) {

//             int leaf1 = getLeaf(s1);
//             int leaf2 = getLeaf(s2);

//             if (leaf1 != leaf2) {
//                 return false;
//             }
//         }

//         return s1.isEmpty() && s2.isEmpty();
//     }

//     int getLeaf(Stack<TreeNode> stack) {

//         while (true) {

//             TreeNode node = stack.pop();

//             if (node.right != null) {
//                 stack.push(node.right);
//             }

//             if (node.left != null) {
//                 stack.push(node.left);
//             }

//             if (node.left == null && node.right == null) {
//                 return node.val;
//             }
//         }
//     }
// }
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeaves(root1, list1);
        getLeaves(root2, list2);

        return list1.equals(list2);
    }

    void getLeaves(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        getLeaves(root.left, list);
        getLeaves(root.right, list);
    }
}