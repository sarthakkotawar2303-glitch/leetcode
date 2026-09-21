
//    BASIC RECURSIVE APPROACH

// class Solution {
//     public int maxAmt(int idx,int[] nums){

//         if(idx<0) return 0;

//         if(idx==0) return nums[0];

//         int pick=maxAmt(idx-2,nums)+nums[idx];
//         int notPick=maxAmt(idx-1,nums);

//         return Math.max(pick,notPick);
//     }
//     public int rob(int[] nums) {
//         return maxAmt(nums.length-1,nums);
//     }
// }


// MEMORIZATION

// class Solution {

//     int[] dp;
//     public int maxAmt(int idx,int[] nums){

//         if(idx<0) return 0;

//         if(idx==0) return nums[0];

//         if(dp[idx]!=-1) return dp[idx];

//         int pick=maxAmt(idx-2,nums)+nums[idx];
//         int notPick=maxAmt(idx-1,nums);

//         return dp[idx]=Math.max(pick,notPick);
//     }
//     public int rob(int[] nums) {
//         dp=new int[nums.length];
//         Arrays.fill(dp,-1);
//         return maxAmt(nums.length-1,nums);
//     }
// }


//TABULATION 


class Solution {


    public int rob(int[] nums) {
        int p1=nums[0];
        int p2=0;

        for(int i=1;i<nums.length;i++){
            int pick=nums[i];

            if(i>1) pick+=p2;

            int notPick=0+p1;

            int curr=Math.max(pick,notPick);

            p2=p1;
            p1=curr;
        }

        return p1;
    }
}



