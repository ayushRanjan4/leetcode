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
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int max=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode u=q.poll();
                map.put(u.val,map.getOrDefault(u.val,0)+1);
                max=Math.max(max,map.get(u.val));
                if(u.left!=null) q.offer(u.left);
                if(u.right!=null) q.offer(u.right);
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==max) list.add(key);
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
*/



class Solution {
    TreeNode prev=null;
    int count=0;
    int countMax=0;

    ArrayList<Integer> list=new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inoder(root);

        int[] ans=new int[list.size()];

        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    void inoder(TreeNode r){
        if(r==null) return ;

        inoder(r.left);

        if(prev!=null && r.val==prev.val){
            count++;
        }
        else{
            count=1;
        }
        prev=r;

        if(count>countMax){
            countMax=count;
            list.clear();
            list.add(r.val);
        }

        else if(count==countMax){
            list.add(r.val);
        }

        inoder(r.right);
    }

}