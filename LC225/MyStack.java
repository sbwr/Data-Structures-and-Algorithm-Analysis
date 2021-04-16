package LC225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue; // Queue是一个接口，LinkedList中有实现该接口
    /** Initialize your data structure here. */
    Queue<Integer> queue2;
    public MyStack() {
        queue = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (queue.isEmpty() == true) {
            queue.add(x);
        }
        else {
            // 使用queue2作为新的存储队列
            queue2.add(x);
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                queue2.add(queue.poll());
            }
            Queue<Integer> tmp = queue;
            queue = queue2;
            queue2 = tmp;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
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
