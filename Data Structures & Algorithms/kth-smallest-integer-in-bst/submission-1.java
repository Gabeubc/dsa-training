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
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        rKthSmallest(root, heap);
        for(int i=0; i<k-1; i++) heap.poll();
        return heap.poll();
    }
    public void rKthSmallest(TreeNode root, PriorityQueue<Integer> heap){
        if(root==null) return;
        heap.add(root.val);
        if(root.left!=null) rKthSmallest(root.left,  heap);
        if(root.right!=null) rKthSmallest(root.right, heap);
    }
}
