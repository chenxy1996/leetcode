package 栈队列互相实现.两个队列实现栈;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        if (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = queue1.remove();
        while (queue2.size() > 1) {
            queue1.add(queue2.remove());
        }
        Queue<Integer> tmp = queue2;
        queue2 = queue1;
        queue1 = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty() && queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        System.out.println(myStack.top());
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }
}
