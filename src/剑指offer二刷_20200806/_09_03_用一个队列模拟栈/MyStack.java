package 剑指offer._0_剑指offer二刷_20200806._09_03_用一个队列模拟栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用一个 queue 实现
 */
public class MyStack {
    Deque<Integer> deque = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.addLast(x);
        for (int i = 0; i < deque.size() - 1; i++) {
            deque.addLast(deque.removeFirst());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.isEmpty() ? -1 : deque.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
