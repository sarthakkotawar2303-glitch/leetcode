class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        st.push(0);
        for(char c:s.toCharArray()){
           
            if(c=='(') st.push(0);
            else {
                int score=st.pop();

                if(score==0){
                    st.push(st.pop()+1);
                }else{
                    st.push(st.pop()+(2*score));
                }
            }
    
        }
        return st.peek();
    }
}