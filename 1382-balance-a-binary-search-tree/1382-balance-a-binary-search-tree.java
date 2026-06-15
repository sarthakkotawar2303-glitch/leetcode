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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode>list=new ArrayList<>();
        Inorder(list,root);

        return  BuildTree(list,0,list.size()-1);
    }
    public void Inorder(List<TreeNode>list,TreeNode root){
        if(root==null) return;

        Inorder(list,root.left);
        list.add(root);
        Inorder(list,root.right);
    }
    public TreeNode BuildTree(List<TreeNode>list,int left,int right){
              if(left>right) return null;

              int mid=left+(right-left)/2;
              TreeNode root=list.get(mid);

              

                root.left=BuildTree(list,left,mid-1);
              

                root.right=BuildTree(list,mid+1,right);
              

              return root;
    }
}