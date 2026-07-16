class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] prefixGcd=new int[n];

        int maxEle=0;
        for(int i=0;i<n;i++){
            maxEle=Math.max(maxEle,nums[i]);
            prefixGcd[i]=Gcd(maxEle,nums[i]);
        }

        Arrays.sort(prefixGcd);

        int left=0;
        int right=n-1;
        long Sum=0;

        while(left<right){
            Sum+=Gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        
        return Sum;
    }

    private int Gcd(int a, int b) {

        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}