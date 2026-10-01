class Solution {
    public boolean isValid(String s) {

        Stack<Character>st=new Stack<>();
        char[] ns=s.toCharArray();
        

        for(char c:ns){
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else if(!st.isEmpty() && c==')' &&  st.peek()=='('){
                st.pop();
            }else if(!st.isEmpty() && c==']' &&  st.peek()=='['){
                st.pop();
            }else if(!st.isEmpty() && c=='}' &&  st.peek()=='{'){
                st.pop();
            }else{
                return false;
            }
        }

        return st.isEmpty();
        
    }
}