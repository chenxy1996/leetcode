package 剑指offer二刷_20200806._31_栈的压入弹出序列;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return true;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        int i = 0;
        int j = 0;
        int len = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < len) {
            if (stack.isEmpty()) {
                stack.addLast(pushed[i++]);
            } else {
                if (stack.peekLast() == popped[j]) {
                    stack.removeLast();
                    j++;
                } else {
                    if (i < len) {
                        stack.addLast(pushed[i++]);
                    }
                }
            }
        }
        while (j < len && popped[j] == stack.peekLast()) {
            j++;
            stack.removeLast();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
