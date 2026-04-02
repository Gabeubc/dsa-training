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
    public TreeNode invertTree(TreeNode root) {
        rInvertTree(root);
        return root;
    }
    public void rInvertTree(TreeNode root){
        TreeNode curr=root;
        if(root==null) return;
        rInvertTree(root.left);
        rInvertTree(root.right);
        TreeNode tmp=curr.right;
        curr.right=curr.left;
        curr.left=tmp;
    }
}
