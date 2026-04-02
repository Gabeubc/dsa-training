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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            if(subRoot==null) return true;
            return false;
        }
        Deque<TreeNode> q=new ArrayDeque<>();
        q.addLast(root);
        while(q.size()!=0){
            TreeNode curr=q.removeFirst();
            if(curr.val==subRoot.val){
                if(sameTree(curr, subRoot)) return true;
            }
            if(curr.left!=null) q.addLast(curr.left);
            if(curr.right!=null) q.addLast(curr.right);
        }
        return false;
    }

    public boolean sameTree(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p!=null && q==null) return false;
        if(p==null && q!=null) return false;
        if(p!=null && q!=null && p.val!=q.val) return false;
        return p.val==q.val ? sameTree(p.left, q.left) &&
        sameTree(p.right, q.right): false;
    }
}
