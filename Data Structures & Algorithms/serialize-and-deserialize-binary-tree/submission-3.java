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

public class Codec {

    int cursor=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode curr=q.remove();
                if(curr!=null){
                    sb.append(String.valueOf(curr.val).length()).append(',').append(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }else{
                    sb.append(1).append(',').append('#');
                }
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper(data);
    }

    private TreeNode deserializeHelper(String data){
        if(data.length()==0) return null;
        TreeNode root=new TreeNode(charToInt(data));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            double size=q.size();
            for(int i=0; i<size; i++){
                TreeNode curr=q.remove();
                if(cursor<data.length()){
                    int val=charToInt(data);
                    if(curr!=null && val!=-1001){
                        curr.left=new TreeNode(val);
                        q.add(curr.left);
                    }
                }
                if(cursor<data.length()){
                    int val=charToInt(data);
                    if(curr!=null && val!=-1001){
                        curr.right=new TreeNode(val);
                        q.add(curr.right);
                    }
                }
            }
        }
        return root;
    }

    private int charToInt(String data){
        int end=data.indexOf(',', cursor);
        String lenStr=data.substring(cursor, end);
        int len=Integer.parseInt(lenStr);
        cursor+=(lenStr.length()+1+len);
        if(data.substring(end+1, end+len+1).equals("#")) return -1001;
        int res=Integer.parseInt(data.substring(end+1, end+len+1));
        return res;
    }

}
