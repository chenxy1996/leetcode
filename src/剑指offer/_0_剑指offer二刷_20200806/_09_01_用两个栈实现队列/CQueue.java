package 剑指offer._0_剑指offer二刷_20200806._09_01_用两个栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.removeLast();
    }
}
