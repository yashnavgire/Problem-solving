class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        
        for (String s : path.split("/")) {
            if (s.equals("..") && !st.isEmpty()) {
                st.pop();
            } else if (!set.contains(s)) {
                st.push(s);
            }
        }
        
        String res = "";
        
        while (!st.isEmpty()) {
            res = "/" + st.pop() + res;
        }
        
        return res.isEmpty() ? "/" : res;
    }
}
