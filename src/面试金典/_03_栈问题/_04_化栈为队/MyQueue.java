package 面试金典._03_栈问题._04_化栈为队;

import java.util.Stack;

// 用两个栈实现一个队列
public class MyQueue {
    private Stack<Integer> a = new Stack<>();
    private Stack<Integer> b = new Stack<>();

    public MyQueue() {
    }

    public void push (int x) {
        if (a.isEmpty() && b.isEmpty()) {
            b.push(x);
        } else {
            a.push(x);
            if (b.isEmpty()) {
                swap();
            }
        }
    }

    private void swap() {
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
    }

    public int pop() {
        int res = b.pop();
        if (b.isEmpty()) {
            swap();
        }
        return res;
    }

    public int peek() {
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
    }
}
