class Solution {
    int[] dp;
    public int maxAmt(int idx,int[] nums){

        if(idx<0) return 0;

        if(idx==0) return nums[0];

        if(dp[idx]!=-1) return dp[idx];

        int pick=maxAmt(idx-2,nums)+nums[idx];
        int notPick=maxAmt(idx-1,nums);

        return dp[idx]=Math.max(pick,notPick);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] temp1=new int[nums.length-1];
        int[] temp2=new int[nums.length-1];

        for(int i=0;i<nums.length;i++){
            if(i!=0) temp1[i-1]=nums[i];

            if(i!=nums.length-1) temp2[i]=nums[i]; 
        }
       
        dp=new int[temp1.length];
        Arrays.fill(dp,-1);
        int startSkip=maxAmt(temp1.length-1,temp1);

        dp=new int[temp1.length];
        Arrays.fill(dp,-1);

        int endSkip=maxAmt(temp2.length-1,temp2);



        return Math.max(startSkip,endSkip);
    }
}