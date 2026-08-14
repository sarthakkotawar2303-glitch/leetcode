class Solution {
    HashMap<Character,Integer>map=new HashMap<>();
    public int maximumLengthSubstring(String s) {
        char[] cr=s.toCharArray();

        int slow=0;
        int fast;
        int maxLen=0;

        for(fast=0;fast<s.length();fast++){

             map.put(cr[fast],map.getOrDefault(cr[fast],0)+1);
             
            while(map.get(cr[fast])>2){
                map.put(cr[slow],map.get(cr[slow])-1);
                slow++;
            }
            
            maxLen=Math.max(maxLen,fast-slow+1);
               
            
        }
        return maxLen;
    }
}