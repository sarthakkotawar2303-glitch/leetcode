class Solution {
    public int removeElement(int[] nums, int val) {
        int slow=0;
        
        for(int fast=0; fast<nums.length;fast++){
            if(nums[fast]!=val){
                int temp=nums[fast];
                nums[fast]=nums[slow];
                nums[slow]=temp;
                slow++;
            }
        }
        return slow;
    }
}