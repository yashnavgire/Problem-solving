class Solution {
    public String minRemoveToMakeValid(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        
        for (i = 0; i < s.length(); i++) {
            if (sb.charAt(i) == '(') {
                st.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                }
                else {
                    sb.setCharAt(i, '*');
                }
            }    
        }
        
        while (!st.isEmpty()) {
            sb.setCharAt(st.pop(), '*');
        }
        
        return sb.toString().replaceAll("\\*", "");
    }
}
