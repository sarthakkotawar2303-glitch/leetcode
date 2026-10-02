class Solution {
    int[][] dp;

    //memorization
    public int memorization(int idx, int target, int[] nums) {

        if (idx < 0) {
            return target == 0 ? 1 : 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];

        int not_take = memorization(idx - 1, target, nums);
        int take = 0;
        if (nums[idx] <= target) {
            take = memorization(idx - 1, target - nums[idx], nums);
        }
        return dp[idx][target]=take + not_take;
    }

    //recursive-2  Appraoch
    public int recursiveAppraoch_two(int idx, int target, int[] nums) {

        if (idx < 0) {
            return target == 0 ? 1 : 0;
        }

        int not_take = recursiveAppraoch_two(idx - 1, target, nums);
        int take = 0;
        if (nums[idx] <= target) {
            take = recursiveAppraoch_two(idx - 1, target - nums[idx], nums);
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

        int sum = 0;
        for (int i : nums)
            sum += i;

        if (Math.abs(target) > sum)
            return 0;
        if ((sum + target) % 2 != 0)
            return 0;

        dp=new int[nums.length][((target+sum)/2)+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }

        // return recursiveAppraoch_two(nums.length - 1, (target + sum) / 2, nums);
        return memorization(nums.length - 1, (target + sum) / 2, nums);
    }
}