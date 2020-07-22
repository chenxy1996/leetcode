package jianZhiOffer._30_包含min函数的栈20200722;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> a;
    private Stack<Integer> b;

    /** initialize your data structure here. */
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
        if (b.isEmpty() || b.peek() >= x) {
            b.push(x);
        }
    }

    public void pop() {
        if (a.pop().equals(b.peek())) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
