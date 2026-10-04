class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);

        //current digit
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {

            //compare with prev digits
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];

                } else if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    count[i] += count[j];
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxLen)
                c += count[i];
        }
        return c;
    }
}