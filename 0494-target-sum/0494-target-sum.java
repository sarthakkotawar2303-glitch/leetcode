class Solution {

    public int recursiveAppraoch(int idx,int target,int[]nums){

        
        if(idx<0){
            if(target==0) return 1;
             return 0;
        }

        int add=recursiveAppraoch(idx-1,target-nums[idx],nums);
        int sub=recursiveAppraoch(idx-1,target+nums[idx],nums);

        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recursiveAppraoch(nums.length-1,target,nums);
    }
}