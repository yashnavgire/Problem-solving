// Problem Link :- https://leetcode.com/problems/validate-stack-sequences/submissions/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0, flag = 0;
        Stack<Integer> st = new Stack<>();
        
        for (i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);
            
            if (!st.isEmpty()) {
                while (!st.isEmpty()) {
                    int top = st.peek();
                    
                    if (top == popped[j]) {
                        st.pop();
                        j++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        
        while (!st.isEmpty() && j < popped.length) {
            int top = st.peek();

            if (top == popped[j]) {
                st.pop();
                j++;
            }
            else {
                flag = 1;
                break;
            }
        }
        
        return flag == 1 ? false : true; 
    }
}
