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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gainFromSubTree(root);
        return max;
    }
    public int gainFromSubTree(TreeNode root){
        if(root==null) return 0;
        int leftGain=Math.max(gainFromSubTree(root.left), 0);
        int rightGain=Math.max(gainFromSubTree(root.right), 0);
        int pathSum= root.val+leftGain+rightGain;
        max=Math.max(max, pathSum);
        return root.val+Math.max(leftGain, rightGain);
    }
}
