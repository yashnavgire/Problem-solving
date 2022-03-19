class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int length = s.length();
        int curr = 0, lastno = 0, res = 0;
        char op = '+';
        
        for (int i = 0; i < length; i++) {
            char currchar = s.charAt(i);
            if (Character.isDigit(currchar)) {
                curr = (curr * 10) + (currchar - '0');
            }
            
            if (!Character.isDigit(currchar) && !Character.isWhitespace(currchar) || i == length - 1) {
                if (op == '+' || op == '-') {
                    res += lastno;
                    lastno = (op == '+') ? curr : -curr;
                } else if (op == '*') {
                    lastno = lastno * curr;
                } else if (op == '/') {
                    lastno = lastno / curr;
                }
                
                op = currchar;
                curr = 0;
            }
        }
        
        res += lastno;
        return res;
        
    }
}
