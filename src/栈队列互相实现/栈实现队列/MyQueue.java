package 栈队列互相实现.栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();

    public void addLast(int arg) {
        stack1.addLast(arg);
    }

    public int peekFirst() {
        if (!stack2.isEmpty()) {
            return stack2.removeLast();
        }
        while (!stack1.isEmpty()) {
            stack2.addLast(stack1.removeLast());
        }
        return stack2.isEmpty() ? -1 : stack2.peekLast();
    }

    public int removeFirst() {
        peekFirst();
        return stack2.isEmpty() ? -1 : stack2.removeLast();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.addLast(1);
        System.out.println(queue.peekFirst());
        queue.addLast(2);
        System.out.println(queue.peekFirst());
    }
}
