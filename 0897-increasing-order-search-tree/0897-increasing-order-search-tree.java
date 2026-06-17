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
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return  null;
       
       TreeNode leftSide=increasingBST(root.left);
       TreeNode rightSide=increasingBST(root.right);
root.left=null;
       root.right=rightSide;

       if(leftSide!=null){
        TreeNode temp=leftSide;
        while(temp.right!=null){
            temp=temp.right;
        };
        temp.right=root;
        return leftSide;
       }
       return root;
    }
   
}