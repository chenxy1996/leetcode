package jianZhiOffer._30_包含min函数的栈;

import java.util.Objects;

public class MinStack {
    private Node head;

    private static class Node {
        private int val;
        private Node next;
        private Node min;

        private Node(int val, Node next, Node min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        Node newNode;
        if (head == null) {
            newNode = new Node(x, null, null);
            newNode.min = newNode;
        } else {
            if (head.min.val > x) {
                newNode = new Node(x, head, null);
                newNode.min = newNode;
            } else {
                newNode = new Node(x, head, head.min);
            }
        }
        head =  newNode;
    }

    public void pop() {
        Objects.nonNull(head);
        head = head.next;
    }

    public int top() {
        Objects.nonNull(head);
        return head.val;
    }

    public int min() {
        Objects.nonNull(head);
        return head.min.val;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}
