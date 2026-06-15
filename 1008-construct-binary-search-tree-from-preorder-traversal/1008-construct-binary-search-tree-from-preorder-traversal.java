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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return Helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode Helper(int[] preorder,int left,int right){
        if(i >= preorder.length || preorder[i]>right || preorder[i]<left){
            return null;
        }

        int val=preorder[i++];
        TreeNode node=new TreeNode(val);

        node.left=Helper(preorder,left,node.val);
        node.right=Helper(preorder,node.val,right);

        return node;

    }
}