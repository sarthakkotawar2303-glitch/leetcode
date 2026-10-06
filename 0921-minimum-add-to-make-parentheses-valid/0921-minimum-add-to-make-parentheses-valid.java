class Solution {
    public int minAddToMakeValid(String s) {
        
        int open=0;
        int need=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                open++;
            }else{
                if(open>0) open--;
                else need++;
            }
        }
        return open+need;
    }
}