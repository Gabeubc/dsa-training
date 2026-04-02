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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null && p.val!=q.val) return false;
        if(p!=null && q==null) return false;
        if(p==null && q!=null) return false;
        if(p==null && q==null) return true;
        Deque<TreeNode> q1=new ArrayDeque<>();
        Deque<TreeNode> q2=new ArrayDeque<>();
        q1.addLast(p);
        q2.addLast(q);
        while(q1.size()!=0 && q2.size()!=0){
            int n1ItemAtLevel=q1.size();
            int n2ItemAtLevel=q2.size();
            if(n1ItemAtLevel!=n2ItemAtLevel) return false;
            for(int i=0; i<n1ItemAtLevel; i++){
                TreeNode t1=q1.removeFirst();
                TreeNode t2=q2.removeFirst();
                if(t1.left==null && t2.left!=null) return false;
                if(t1.left!=null && t2.left==null) return false;
                if(t1.left!=null && t2.left!=null && t1.left.val!=t2.left.val) return false;
                if(t1.left!=null){
                    q1.addLast(t1.left);
                    q2.addLast(t2.left);
                }
                if(t1.right==null && t2.right!=null) return false;
                if(t1.right!=null && t2.right==null) return false;
                if(t1.right!=null && t2.right!=null && t1.right.val!=t2.right.val) return false;
                if(t1.right!=null){
                    q1.addLast(t1.right);
                    q2.addLast(t2.right);
                }
            }
        }
        return q1.size()==q2.size();
    }
}
