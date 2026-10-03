class Solution {
    int[][] dp;

    //--- Memorization
    public int memorization(int idx, int prev, int[] nums) {

        if (idx == nums.length) {
            //if(nums[idx]>prev) return 1;
            return 0;
        }
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];

        int take = 0;
        if (prev==-1 || nums[idx] > nums[prev]) {
            take = 1 + memorization(idx + 1,idx, nums);
        }

        int not_take = memorization(idx + 1, prev, nums);

        return dp[idx][prev+1]=Math.max(take, not_take);
    }

    //--- RecursiveAppraoch
    // public int recursiveAppraoch(int idx,int prev,int[] nums){

    //         if(idx==nums.length){
    //             //if(nums[idx]>prev) return 1;
    //             return 0;
    //         }

    //         int take=0;
    //         if(nums[idx]>prev){
    //            take=1+recursiveAppraoch(idx+1,nums[idx],nums);
    //         }

    //         int not_take=recursiveAppraoch(idx+1,prev,nums);

    //         return Math.max(take,not_take);
    // }
    public int lengthOfLIS(int[] nums) {
       // return recursiveAppraoch(0, -(int) 1e5, nums);

       
       dp=new int[nums.length][nums.length+1];
       for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);

       return memorization(0,-1,nums);
    }
}