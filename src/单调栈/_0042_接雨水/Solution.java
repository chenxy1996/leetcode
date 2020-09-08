package 单调栈._0042_接雨水;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            int h = height[i];
            while (!stack.isEmpty() && h > height[stack.peekLast()]) {
                int top = stack.removeLast();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peekLast() - 1;
                int deltaHeight = Math.min(h, height[stack.peekLast()]) - height[top];
                ans += distance * deltaHeight;
            }
            stack.addLast(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
