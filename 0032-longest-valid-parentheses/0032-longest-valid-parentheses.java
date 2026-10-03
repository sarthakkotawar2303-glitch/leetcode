class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st=new Stack();
        char[]c=s.toCharArray();
        int maxLen=0;
        st.push(-1);


        for(int i=0;i<c.length;i++){
            if(c[i]=='(') st.push(i);
            else if(c[i]==')'){
                st.pop();
                if(st.isEmpty()) st.push(i);
                else maxLen=Math.max(maxLen,i-st.peek());

            }
        }
        return maxLen;
    }
}