package 面试金典._03_栈问题._03_堆盘子;

import java.util.*;

public class StackOfPlates {
    private final List<Deque<Integer>> dequeList = new ArrayList<>();
    private final int cap;

    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (cap == 0) {
            return;
        }
        int size = dequeList.size();
        Deque<Integer> deque;
        if (size == 0 || (deque = dequeList.get(size - 1)).size() >= cap) {
            deque = new ArrayDeque<>();
            dequeList.add(deque);
        }
        deque.addLast(val);
    }

    public int pop() {
        if (cap == 0) {
            return -1;
        }
        int size = dequeList.size();
        if (size == 0) {
            return -1;
        }
        Deque<Integer> deque = dequeList.get(size - 1);
        int res = deque.removeLast();
        checkDequeIsEmpty(size - 1);
        return res;
    }

    public int popAt(int index) {
        if (cap == 0) {
            return -1;
        }
        int size = dequeList.size();
        if (size == 0 || index >= size) {
            return -1;
        }
        Deque<Integer> deque = dequeList.get(index);
        int res = deque.removeLast();
        checkDequeIsEmpty(index);
        return res;
    }

    private void checkDequeIsEmpty(int index) {
        if (index < dequeList.size()) {
            int size = dequeList.get(index).size();
            if (size == 0) {
                dequeList.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(2);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);
        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.popAt(0));
    }
}
