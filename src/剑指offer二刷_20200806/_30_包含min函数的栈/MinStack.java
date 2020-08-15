package 剑指offer._0_剑指offer二刷_20200806._30_包含min函数的栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack1.addLast(x);
        if (stack2.isEmpty() || x <= stack2.peekLast()) {
            stack2.addLast(x);
        }
    }

    public void pop() {
        int val = stack1.removeLast();
        if (val == stack2.peekLast()) {
            stack2.removeLast();
        }
    }

    public int top() {
        return stack1.peekLast();
    }

    public int min() {
        return stack2.peekLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(5);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
    }
}
