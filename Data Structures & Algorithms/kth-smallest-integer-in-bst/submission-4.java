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
    int count=0;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        rKthSmallest(root, k);
        return res;
    }
    public void rKthSmallest(TreeNode root, int k){
        if(root==null) return;
        if(root.left!=null) rKthSmallest(root.left, k);
        count++;
        if(count==k){
            res=root.val;
            return;
        }
        if(count<k && root.right!=null) rKthSmallest(root.right, k);
    }
}
