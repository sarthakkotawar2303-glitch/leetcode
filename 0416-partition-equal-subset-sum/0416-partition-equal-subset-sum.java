class Solution {

    Boolean[][] dp;

    // Recursive Approach
    public boolean recursiveApproach(int[] nums, int idx, int target) {

        if (target == 0) return true;

        if (idx == 0) return nums[0] == target;

        boolean not_take =
            recursiveApproach(nums, idx - 1, target);

        boolean take = false;

        if (nums[idx] <= target) {
            take =
                recursiveApproach(
                    nums,
                    idx - 1,
                    target - nums[idx]
                );
        }

        return take || not_take;
    }


    // Memoization
    public boolean memorization(int[] nums, int idx, int target) {

        if (target == 0) return true;

        if (idx == 0) return nums[0] == target;

        if (dp[idx][target] != null) {
            return dp[idx][target];
        }

        boolean not_take =
            memorization(nums, idx - 1, target);

        boolean take = false;

        if (nums[idx] <= target) {
            take =
                memorization(
                    nums,
                    idx - 1,
                    target - nums[idx]
                );
        }

        return dp[idx][target] = take || not_take;
    }


    // Tabulation
    public boolean tabulation(int[] nums, int target) {

        int n = nums.length;

        boolean[][] dp = new boolean[n][target + 1];

        // Target 0 is always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // First element
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // Fill remaining table
        for (int i = 1; i < n; i++) {

            for (int t = 1; t <= target; t++) {

                // Don't take current element
                boolean notTake = dp[i - 1][t];

                // Take current element
                boolean take = false;

                if (nums[i] <= t) {
                    take = dp[i - 1][t - nums[i]];
                }

                dp[i][t] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }


    // Main
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        // Memoization
        // dp = new Boolean[nums.length][target + 1];
        // return memorization(nums, nums.length - 1, target);

        // Tabulation
        return tabulation(nums, target);
    }
}