class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int fix = 0; fix < nums.length - 2; fix++) {
            if (fix > 0 && nums[fix] == nums[fix - 1])
                continue;
            int left = fix + 1;
            int right = nums.length - 1;

            while (left < right) {

                if (nums[fix] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[fix] + nums[left] + nums[right] > 0) {
                    right--;
                } else {

                    ans.add(new ArrayList(Arrays.asList(nums[fix], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}