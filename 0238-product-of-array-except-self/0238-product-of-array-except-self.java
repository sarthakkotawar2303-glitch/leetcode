class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preFix=new int[nums.length];
        int[] suFix=new int[nums.length];
        
        preFix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
           preFix[i]=preFix[i-1]*nums[i];
        }
         suFix[nums.length-1]=nums[nums.length-1];
        for(int j=nums.length-2;j>=0;j--){
                suFix[j]=suFix[j+1]*nums[j];
        }

        int[] ans=new int[nums.length];
        ans[0]=suFix[1];

        for(int i=1;i<nums.length-1;i++){
            ans[i]=preFix[i-1]*suFix[i+1];
        }
        ans[nums.length-1]=preFix[nums.length-2];

        return ans;
        
    }
}