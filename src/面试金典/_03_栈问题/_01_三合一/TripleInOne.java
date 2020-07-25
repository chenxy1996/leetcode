package 面试金典._03_栈问题._01_三合一;

import java.util.ArrayList;

public class TripleInOne {
    private final int[] elements;
    private final int stackSize;
    private int[] p = new int[3];

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        elements = new int[3 * stackSize];
        for (int i = 1; i < 3; i++) {
            p[i] = p[i - 1] + stackSize;
        }
    }

    public void push(int stackNum, int value) {
        int i = p[stackNum];
        if (i < (stackNum + 1) * stackSize) {
            elements[i] = value;
            p[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        int i = p[stackNum] - 1;
        int res = elements[i];
        p[stackNum] = i;
        return res;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return elements[p[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return p[stackNum] == stackNum * stackSize;
    }

    public static void main(String[] args) {
        TripleInOne stacks = new TripleInOne(2);
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.peek(0));
    }
}
