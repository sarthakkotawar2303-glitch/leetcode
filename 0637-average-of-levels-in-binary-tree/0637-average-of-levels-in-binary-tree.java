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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList();
        List<Double>avg=new ArrayList<>();
        if(root==null) return avg;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            double sum=0;

            for(int i=size;i>0;i--){
              TreeNode temp=q.poll();
              sum+=temp.val;

              if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }

            avg.add(sum/size);
            
        }
        return avg;
    }
}