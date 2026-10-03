class Solution {

    int[][] dp;

    //--- Memorization
    public int memorization(int idx, int prev, int[] nums) {

        if (idx == nums.length) {
            return 0;
        }

        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];

        int take = 0;

        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + memorization(idx + 1, idx, nums);
        }

        int not_take = memorization(idx + 1, prev, nums);

        return dp[idx][prev + 1] = Math.max(take, not_take);
    }


    //--- Tabulation
    public int tabulation(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


    //--- Recursive Approach
    // public int recursiveAppraoch(int idx, int prev, int[] nums) {

    //     if (idx == nums.length) {
    //         return 0;
    //     }

    //     int take = 0;

    //     if (prev == -1 || nums[idx] > nums[prev]) {
    //         take = 1 + recursiveAppraoch(idx + 1, idx, nums);
    //     }

    //     int not_take = recursiveAppraoch(idx + 1, prev, nums);

    //     return Math.max(take, not_take);
    // }


    public int lengthOfLIS(int[] nums) {

        // Recursive
        // return recursiveAppraoch(0, -1, nums);


        // Memoization
        /*
        dp = new int[nums.length][nums.length + 1];

        for (int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], -1);

        return memorization(0, -1, nums);
        */


        // Tabulation
        return tabulation(nums);
    }
}