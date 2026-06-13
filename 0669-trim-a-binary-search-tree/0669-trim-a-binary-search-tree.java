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
 Algorithm with Logic
 If node == null:Logic: An empty tree requires no trimming.
    Return null.
 If node.val < low:Logic: The current node and its entire left subtree are too small.
 Discard them. Move to the right child to find valid values.
 If node.val > high:Logic: The current node and its entire right subtree are too large. 
 Discard them. Move to the left child to find valid values.If low <= node.val <= high:Logic: The current node is valid and must be kept. 
 However, its children might still have out-of-bounds nodes. Recursively trim both subtrees and reattach them.
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;

        if(root.val<low){
           return trimBST(root.right,low,high);
        }
        if(root.val>high){
            return trimBST(root.left,low,high);
        }
       root.left= trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);

        return root;
    }
}
