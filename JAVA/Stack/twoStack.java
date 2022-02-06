// Problem Link :- https://www.codingninjas.com/codestudio/problems/two-stacks_983634?topList=top-microsoft-coding-interview-questions&leftPanelTab=1

import java.util.*;

public class TwoStack {
	int ele;
    int act;
    Stack<Integer> st1;
    Stack<Integer> st2;
	// Initialize TwoStack
    public TwoStack(int s) {
		ele = s;
        act = 0;
        st1  =new Stack<>();
        st2 = new Stack<>();
	}

	// Push in stack 1.
	public void push1(int num) {
        if (act >= ele) {
            return;
        }
        st1.push(num);
        act++;
	}

	// Push in stack 2.
	public void push2(int num) {
		if (act >= ele) {
            return;
        }
        st2.push(num);
        act++;
	}

	// Pop from stack 1 and return popped element.
	public int pop1() {
        int top = -1;
        if (!st1.isEmpty()) {
           top = st1.pop();
		   act--; 
        }
        
        return top;
	}

	// Pop from stack 2 and return popped element.
	public int pop2() {
		int top = -1;
        if (!st2.isEmpty()) {
           top = st2.pop();
		   act--; 
        }
        return top;
	}
}
