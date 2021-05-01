package LC232;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack, stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty() == true) {
            stack.add(x);
        }
        else {
            int size = stack.size();
            for (int i = 0; i < size; i ++) {
                stack2.push(stack.pop());
            }
            stack.push(x);
            for (int i = 0; i < size; i ++) {
                stack.push(stack2.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
