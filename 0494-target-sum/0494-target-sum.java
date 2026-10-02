class Solution {
    int[][] dp;
    
    //recursive-2  Appraoch
    public int recursiveAppraoch_two(int idx, int target, int[] nums) {
      
       if(idx < 0) {
        return target == 0 ? 1 : 0;
    }

       int not_take=recursiveAppraoch_two(idx-1,target,nums);
       int take=0;
       if(nums[idx]<=target){
         take=recursiveAppraoch_two(idx-1,target-nums[idx],nums);
       }
       return take + not_take;
    }

    //recursive-1  Appraoch
    public int recursiveAppraoch(int idx, int target, int[] nums) {

        if (idx < 0) {
            if (target == 0)
                return 1;
            return 0;
        }

        int add = recursiveAppraoch(idx - 1, target - nums[idx], nums);
        int sub = recursiveAppraoch(idx - 1, target + nums[idx], nums);

        return add + sub;
    }

    //main
    public int findTargetSumWays(int[] nums, int target) {
        // return recursiveAppraoch(nums.length - 1, target, nums);

        int sum=0;
        for(int i:nums) sum+=i;

        if(Math.abs(target)>sum) return 0;
        if((sum + target) % 2 != 0)
            return 0;

        return recursiveAppraoch_two(nums.length-1,(target+sum)/2,nums);
    }
}