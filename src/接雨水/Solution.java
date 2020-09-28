package 接雨水;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            int h = height[i];
            while (!stack.isEmpty() && height[stack.peekLast()] <= h) {
                int top = stack.removeLast();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peekLast() - 1;
                int depth = Math.min(height[stack.peekLast()], h) - height[top];
                ans += depth * distance;
            }
            stack.addLast(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] hs = {4,3,3,3,3,4};
        System.out.println(trap(hs));
    }
}
