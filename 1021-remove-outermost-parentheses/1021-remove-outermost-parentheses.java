class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder st = new StringBuilder();

        int depth = 0;
        int open = 1;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth == 0) {
                    open++;
                    depth++;
                } else {
                    open++;
                    depth++;
                    st.append('(');

                }

            } else {
                if (depth == 1) {
                    open--;
                    depth--;
                } else {
                    open--;
                    depth--;
                    st.append(')');
                }

            }
        }
        return st.toString();
    }
}