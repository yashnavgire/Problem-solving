// Problem Link :- https://leetcode.com/problems/valid-parentheses/submissions/

class Solution {
    public boolean isValid(String s) {
        int flag = 0;
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
                flag = 1;
            }
            else {
                if (st.size() >= 1) {
                    char top = st.pop();
                    System.out.println("top" + " " + top);

                    if (top == '(' && ch != ')') {
                        return false;
                    } else if (top == '{' && ch != '}') {
                        return false;
                    } else if (top == '[' && ch != ']') {
                        return false;
                    }   
                }
                else {
                    return false;
                }
            }
        }
        
        return (flag == 1 && st.size() == 0) ? true : false;
    }
}
