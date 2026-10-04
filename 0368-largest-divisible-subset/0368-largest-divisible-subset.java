class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int[] dp = new int[nums.length];
        int[] map = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(map, -1);
        Arrays.sort(nums);
        //current digit
        int maxLen = 1;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            //checks  prev digits where complete divide curr
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    map[i] = j;
                }
            }

            if (maxLen < dp[i]) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int curr = maxIdx;
        while (curr != -1) {
            arr.add(nums[curr]);
            curr = map[curr];
        }

        return arr;
    }
}