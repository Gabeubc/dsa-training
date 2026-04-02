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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> queue=new ArrayDeque<>();
        int l=0;
        queue.add(root);
        while(queue.size()!=0){
            int nItemForLevel=queue.size();
            boolean depthIncremented=false;
            for(int i=0; i<nItemForLevel; i++){
                TreeNode curr=queue.removeFirst();
                if(!depthIncremented){ 
                    l++;
                    depthIncremented=true;
                }
                if(curr.left!=null) queue.addLast(curr.left);
                if(curr.right!=null) queue.addLast(curr.right);
            }
        }
        return l;
    }
}
