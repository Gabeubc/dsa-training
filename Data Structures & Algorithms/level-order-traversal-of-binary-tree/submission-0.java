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
        if(root==null) return new ArrayList<>();
        Deque<TreeNode> q=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        q.addLast(root);
        while(q.size()>0){
            int nElementAtLevel=q.size();
            List<Integer> item=new ArrayList<>();
            for(int i=0; i<nElementAtLevel; i++){
                TreeNode curr=q.removeFirst();
                item.add(curr.val);
                if(curr.left!=null) q.addLast(curr.left);
                if(curr.right!=null) q.addLast(curr.right);
            }
            res.add(item);
        }
        return res;
    }
}
