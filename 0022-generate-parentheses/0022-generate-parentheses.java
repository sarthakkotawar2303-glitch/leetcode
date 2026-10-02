class Solution {
    ArrayList<String> ans = new ArrayList<>();

    public void backtracking(StringBuilder p, int n, int open, int close) {

        if (p.length() == n * 2) {
            ans.add(p.toString());

        }

        if (open < n) {

            p.append('(');
            backtracking(p, n, open + 1, close);
            p.deleteCharAt(p.length() - 1);
        }
        if (close < open) {
            p.append(')');
            backtracking(p, n, open, close + 1);
            p.deleteCharAt(p.length() - 1);

        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return ans;

        backtracking(new StringBuilder(), n, 0, 0);
        return ans;
    }
}