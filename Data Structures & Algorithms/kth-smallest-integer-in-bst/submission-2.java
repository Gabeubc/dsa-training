/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;a
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res=new ArrayList<>();
        rKthSmallest(root, k, res);
        return res.get(k-1);
    }
    public void rKthSmallest(TreeNode root, int k, List<Integer> mins){
        if(root==null) return;
        if(root.left!=null) rKthSmallest(root.left, k, mins);
        mins.add(root.val);
        if(mins.size()==k) return;
        if(root.right!=null) rKthSmallest(root.right, k, mins);
    }
}
