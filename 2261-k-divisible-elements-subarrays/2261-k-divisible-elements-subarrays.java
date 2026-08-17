class Solution {
    public int countDistinct(int[] nums, int k, int p) {

        int n = nums.length;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            int divisibleCount = 0;
            StringBuilder subarray = new StringBuilder();

            for (int j = i; j < n; j++) {

                subarray.append(nums[j]).append(",");

                if (nums[j] % p == 0) {
                    divisibleCount++;
                }

              if (divisibleCount > k) {
                    break;
                }

                set.add(subarray.toString());
            }
        }

        return set.size();
    }
}