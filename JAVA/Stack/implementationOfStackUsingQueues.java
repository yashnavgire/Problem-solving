// Problem Link :- https://leetcode.com/problems/implement-stack-using-queues/submissions/

class MyStack {
    Deque<Integer> dq;
        
    public MyStack() {
        dq = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        dq.add(x);
    }
    
    public int pop() {
        int peek = dq.pollLast();
        return peek;
    }
    
    public int top() {
        int peek = dq.peekLast();
        return peek;
    }
    
    public boolean empty() {
        int size = dq.size();
        
        return (size <= 0) ? true : false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
