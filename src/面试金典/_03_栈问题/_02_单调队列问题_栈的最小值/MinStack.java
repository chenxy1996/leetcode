package 面试金典._03_栈问题._02_单调队列问题_栈的最小值;

import java.util.Stack;

/**
 * 这种问题是单调队列的典型问题
 */
public class MinStack {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        a.push(x);
        if (b.isEmpty() || b.peek() >= x) {
            b.push(x);
        }
    }

    public void pop() {
        int item = a.pop();
        if (item == b.peek()) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }
}
