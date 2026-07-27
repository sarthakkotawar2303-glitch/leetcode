class Solution {
    public int maxProduct(int[] nums) {
        int maxOne=Integer.MIN_VALUE;
         int maxTwo=Integer.MIN_VALUE;

         for(int num:nums){
            if(num>maxOne){
                maxTwo=maxOne;
                maxOne=num;
            } else if(maxTwo<num){
                maxTwo=num;
            }
         }
         return (maxOne-1)*(maxTwo-1);
          
    }
}