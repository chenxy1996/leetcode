package 剑指offer二刷_20200806._09_02_用两个队列实现栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    Deque<Integer> deque1 = new ArrayDeque<>();
    Deque<Integer> deque2 = new ArrayDeque<>();

    /** Initialize your data structure here.    */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque1.addLast(x);
        while (!deque2.isEmpty()) {
            deque1.addLast(deque2.removeFirst());
        }
        Deque<Integer> tmp = deque2;
        deque2 = deque1;
        deque1 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return empty() ? -1 : deque2.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return empty() ? -1 : deque2.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque2.isEmpty();
    }

    public static void main(String[] args) {
//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        System.out.println("-----");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
    }
}
