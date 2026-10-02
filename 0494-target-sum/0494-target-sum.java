class Solution {

    int[][] dp;

    // ---------------------------------------------------------
    // Recursive-2 Approach
    // Target Sum -> Subset Sum -> Count Subsets
    // ---------------------------------------------------------
    public int recursiveAppraoch_two(int idx, int target, int[] nums) {

        // Base Case:
        // If we have processed all elements,
        // check whether we have formed the required sum.
        if (idx < 0) {
            return target == 0 ? 1 : 0;
        }

        // Choice 1: Do NOT take nums[idx]
        int not_take = recursiveAppraoch_two(
            idx - 1,
            target,
            nums
        );

        // Choice 2: Take nums[idx]
        int take = 0;

        if (nums[idx] <= target) {
            take = recursiveAppraoch_two(
                idx - 1,
                target - nums[idx],
                nums
            );
        }

        // Total number of ways
        // = ways without taking + ways after taking
        return take + not_take;
    }


    // ---------------------------------------------------------
    // Recursive-1 Approach
    // Directly put + or - before every number
    // ---------------------------------------------------------
    public int recursiveAppraoch(int idx, int target, int[] nums) {

        // All elements processed
        if (idx < 0) {

            // One valid expression found
            if (target == 0)
                return 1;

            // No valid expression
            return 0;
        }

        // Put '+' before nums[idx]
        int add = recursiveAppraoch(
            idx - 1,
            target - nums[idx],
            nums
        );

        // Put '-' before nums[idx]
        int sub = recursiveAppraoch(
            idx - 1,
            target + nums[idx],
            nums
        );

        // Total number of valid expressions
        return add + sub;
    }


    // ---------------------------------------------------------
    // Main
    // ---------------------------------------------------------
    public int findTargetSumWays(int[] nums, int target) {

        // Direct recursive approach
        // return recursiveAppraoch(nums.length - 1, target, nums);

        int sum = 0;

        // Calculate total sum of all elements
        for (int i : nums) {
            sum += i;
        }


        // If target is outside [-sum, +sum],
        // it is impossible to achieve.
        if (Math.abs(target) > sum)
            return 0;


        // We derive:
        //
        // PositiveSum - NegativeSum = target
        // PositiveSum + NegativeSum = sum
        //
        // Therefore:
        //
        // PositiveSum = (sum + target) / 2
        //
        // It must be an integer.
        if ((sum + target) % 2 != 0)
            return 0;


        // IMPORTANT:
        // Convert Target Sum problem into
        // Count Subsets with a given sum.
        int subsetTarget = (sum + target) / 2;


        // Count subsets having sum = subsetTarget
        return recursiveAppraoch_two(
            nums.length - 1,
            subsetTarget,
            nums
        );
    }
}