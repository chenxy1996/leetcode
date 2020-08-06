package 剑指offer._59_2单调队列_队列的最大值;

import java.util.ArrayDeque;

// 这道题和那个 _30_MinStack 基本一样
public class MaxQueue {
    ArrayDeque<Integer> dequeA = new ArrayDeque<>();
    ArrayDeque<Integer> dequeB = new ArrayDeque<>();

    public MaxQueue() {
    }

    public int max_value() {
        if (dequeA.isEmpty()) {
            return -1;
        }
        return dequeB.peekLast();
    }

    public void push_back(int value) {
        dequeA.addLast(value);
        while (!dequeB.isEmpty() && dequeB.peekFirst() < value) {
            dequeB.removeFirst();
        }
        dequeB.addFirst(value);
    }

    public int pop_front() {
        if (dequeA.isEmpty()) {
            return -1;
        }
        Integer fist = dequeA.removeFirst();
        if (fist.equals(dequeB.peekLast())) {
            dequeB.removeLast();
        }
        return fist;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(5);
        System.out.println(maxQueue.max_value()); // 5
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(3);
        System.out.println(maxQueue.max_value()); // 5
        System.out.println(maxQueue.pop_front()); // 1
        System.out.println(maxQueue.max_value()); // 5
        System.out.println(maxQueue.pop_front()); // 5
        System.out.println(maxQueue.max_value()); // 3
        System.out.println(maxQueue.pop_front()); // 1
        System.out.println(maxQueue.max_value()); // 3
    }
}
