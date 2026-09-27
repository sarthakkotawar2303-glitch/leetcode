class Solution {
    public int findMaxLength(int[] nums) {
        
        // digit idx
        HashMap<Integer,Integer>map=new HashMap<>(); 
        int maxLength=0;
        int currentSum=0;
        

        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
             currentSum+= (nums[i]==0)?-1:1;
            if(map.containsKey(currentSum)){
                int idx=map.get(currentSum);
                maxLength=Math.max(maxLength,i-idx);
            }else{
                map.put(currentSum,i);
            }
        }

        return maxLength;
        
    }
}