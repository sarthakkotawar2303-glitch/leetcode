class Solution {
    Boolean[][] dp;

    public boolean recursiveApproach(int[]nums, int idx,int target){

        if(target==0) return true;
        if(idx==0) return nums[0]==target;
        
        boolean not_take=recursiveApproach(nums,idx-1,target);

        boolean take=false;

        if(nums[idx]<=target){
            take=recursiveApproach(nums,idx-1,target-nums[idx]);
        }

        return take || not_take;

    }

    public boolean memorization(int[]nums, int idx,int target){

        if(target==0) return true;
        if(idx==0) return nums[0]==target;

        if(dp[idx][target] != null) return dp[idx][target];

        boolean not_take=memorization(nums,idx-1,target);

        boolean take=false;

        if(nums[idx]<=target){
            take=memorization(nums,idx-1,target-nums[idx]);
        }

        return dp[idx][target]=take || not_take;

    }

    //main
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;

        if(sum%2!=0) return false;

        int target=sum/2;  

        // return recursiveApproach(nums,nums.length-1,target);

        dp=new Boolean[nums.length][target+1];
       
        return memorization(nums,nums.length-1,target);

    }
}