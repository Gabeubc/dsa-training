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
    int d=0;
    public int diameterOfBinaryTree(TreeNode root) {
        rDiameterOfBinaryTree(root);
        return d;
    }
    int rDiameterOfBinaryTree(TreeNode root){
        if(root==null) return 0;
        int lHeight=rDiameterOfBinaryTree(root.left);
        int rHeight=rDiameterOfBinaryTree(root.right);
        d=Math.max(d, lHeight+rHeight);
        return Math.max(lHeight, rHeight)+1;
    }
}
