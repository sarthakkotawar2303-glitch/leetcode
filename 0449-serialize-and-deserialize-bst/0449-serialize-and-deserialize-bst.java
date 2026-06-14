/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Ene to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "#,";
        return root.val+","+serialize(root.left)+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        Queue<String>q=new LinkedList(Arrays.asList(data.split(",")));
        return buildTree(q);
    }
    public TreeNode buildTree(Queue<String>q){
        if(q.isEmpty()) return null;
    String val =q.poll();
        if(val.equals("#")) return null;

        TreeNode root=new TreeNode(Integer.parseInt(val));
        root.left=buildTree(q);
        root.right=buildTree(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;