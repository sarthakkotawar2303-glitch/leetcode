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
    int currentVal=0;
    int count=0;
    int maxCount=Integer.MIN_VALUE;
    List<Integer>list=new ArrayList<>();

    public int[] findMode(TreeNode root) {
        Inorder(root);
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void Inorder(TreeNode root){
       if(root==null) return;

       Inorder(root.left);
       if(currentVal!=root.val){
         currentVal=root.val;
         count=1;
       }else if(currentVal==root.val){
          count++;
       }

       if(maxCount<count){
          maxCount=count;
          list.clear();
          list.add(root.val);
       }
       else if(maxCount==count){
        list.add(root.val);
       }

       Inorder(root.right);
    }
}