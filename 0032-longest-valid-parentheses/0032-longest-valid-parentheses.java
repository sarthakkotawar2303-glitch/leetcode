class Solution {
    public int longestValidParentheses(String s){
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        char[] c=s.toCharArray();
        int maxLength=0;

        for(int i=0;i<s.length();i++){
            if(c[i]=='('){
                st.push(i);
            }else{
                st.pop();

                //empty means --> new Start
                //we add idx of (new Start)
                if(st.isEmpty()){
                     st.push(i);
                }else{
                    //if not empty means staring idx is present 
                    //we can calculate length (i-start_idx)
                    maxLength=Math.max(maxLength,i-st.peek());

                }
            }
        }
        return maxLength;
    }
}