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

    void rInvertTree(TreeNode root){
        if(root==null) return;
        TreeNode node=root.right;
        root.right=root.left;
        root.left=node;
        rInvertTree(root.left);
        rInvertTree(root.right);
    }
}
