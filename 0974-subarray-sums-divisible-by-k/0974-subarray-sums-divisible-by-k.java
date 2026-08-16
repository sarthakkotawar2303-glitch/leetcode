class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] freq=new int[k];
        int sum=0;
        int count=0;
        freq[0]=1;
        for(int num:nums)
        {
            sum+=num;
            
            int rem=sum % k;
            if(rem<0){
               rem=rem+k;
            }

            count+=freq[rem];
            freq[rem]++;
        }
        return count++;
    }
}