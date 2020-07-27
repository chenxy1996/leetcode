package 单调栈._739_每日温度;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return null;
        }
        int len = T.length;
        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int temp = T[i];
            while (!deque.isEmpty() && T[deque.peekLast()] < temp) {
                int top = deque.removeLast();
                res[top] = i - top;
            }
            deque.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73, 77};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(T)));
    }
}
