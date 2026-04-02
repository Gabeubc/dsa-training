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
    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        Deque<TreeNode> q=new ArrayDeque<>();
        q.addLast(root);
        while(q.size()>0){
            int nNodeAtLevel=q.size();
            for(int i=0; i<nNodeAtLevel; i++){
                TreeNode curr=q.removeFirst();
                if(!findNode(root, curr)) return false;
                if(curr.left!=null) q.addLast(curr.left);
                if(curr.right!=null) q.addLast(curr.right);
            }
        }
        return true;
    }
    public boolean findNode(TreeNode root, TreeNode node){
        if((root.left!=null && root.left.val>=root.val) ||
            (root.right!=null && root.right.val<=root.val)) return false;
        if(root==node) return true;
        if(root.left!=null && root.val>node.val) return findNode(root.left, node);
        if(root.right!=null && root.val<node.val) return findNode(root.right, node);
        return false;
    }
}
