class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] freqDiff = new int[100001]; // Max possible difference given constraints is 10^5
        
        long totalDiff = 0;
        int maxDiff = 0;

        // 1. Calculate absolute differences and populate the frequency array
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freqDiff[diff]++;
            totalDiff += diff;
            maxDiff = Math.max(diff, maxDiff);
        }

        // 2. If total available operations can reduce all differences to 0
        long k = (long) k1 + k2;
        if (totalDiff <= k) {
            return 0;
        }

        // 3. Greedily reduce the largest differences down to smaller ones
        for (int i = maxDiff; i > 0; i--) {
            if (freqDiff[i] > 0) {
                // Determine how many elements at difference 'i' we can decrement by 1
                long take = Math.min(k, (long) freqDiff[i]);
                freqDiff[i] -= take;
                freqDiff[i - 1] += take;
                k -= take;
                
                if (k == 0) break;
            }
        }

        // 4. Calculate the minimum sum of squared differences
        long ans = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (freqDiff[i] > 0) {
                ans += (long) i * i * freqDiff[i];
            }
        }
        
        return ans;
    }
}
