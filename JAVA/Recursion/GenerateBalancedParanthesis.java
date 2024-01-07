class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = n, closed = n;
        String op = "";

        solve(ans, open, closed, op);

        return ans;
    }

    public void solve(List<String> ans, int open, int closed, String op) {

        if (open == closed && open == 0 && closed == 0) {
            ans.add(op);
            return;
        }

        if (open != 0) {
            StringBuffer sb = new StringBuffer();
            sb.append(op);
            sb.append("(");
            solve(ans, open-1, closed, sb.toString());
        }

        if (closed > open) {
            StringBuffer sb = new StringBuffer();
            sb.append(op);
            sb.append(")");
            solve(ans, open, closed-1, sb.toString());
        }

        return;
    }
}
