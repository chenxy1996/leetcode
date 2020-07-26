package 题目._84_困难_柱状图中的最大矩形;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 利用哨兵模式
 */
public class RefinedBetterSolution {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        heights = newHeights;
        heights[0] = -1;
        heights[len + 1] = -1;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        int maxArea = 0;

        for (int i = 1; i < heights.length; i++) {
            int height = heights[i];
            while (heights[deque.peekLast()] > height) {
                int top = deque.removeLast();
                int topHeight = heights[top];
                int area = (i  - deque.peekLast() - 1) * topHeight;
                maxArea = Math.max(maxArea, area);
            }
            deque.addLast(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {3,6,5,8,4,8,1,4};
        System.out.println(largestRectangleArea(heights));
    }
}
