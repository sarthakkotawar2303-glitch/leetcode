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
    int maxSum=0;
    class nodeInfo{
        boolean isBst;
        int min;
        int max;
        int sum;

         nodeInfo(boolean isBst,int min,int max,int sum){
            this.isBst=isBst;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    public nodeInfo postOrder(TreeNode root){
        if(root==null) return new nodeInfo(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);

       nodeInfo leftSide=postOrder(root.left);
       nodeInfo rightSide=postOrder(root.right);

        if(leftSide.isBst && rightSide.isBst && root.val>leftSide.max && root.val<rightSide.min){
           int currentSum=root.val+leftSide.sum+rightSide.sum;
           maxSum=Math.max(maxSum,currentSum);
           int currentLeft=Math.min(root.val,leftSide.min);
           int currentRight=Math.max(root.val,rightSide.max);
           return new nodeInfo(true,currentLeft,currentRight,currentSum);
        }
return new nodeInfo(false,0,0,0);
    }
}