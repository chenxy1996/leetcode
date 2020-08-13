package 单调栈._84_困难_柱状图中的最大矩形;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 利用单调栈
 */
public class BetterSolution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            int val = heights[i];
            while (!deque.isEmpty() && heights[deque.getLast()] > val) {
                int height = heights[deque.removeLast()];
                while (!deque.isEmpty() && heights[deque.peekLast()] == height) {
                    deque.removeLast();
                }
                if (deque.isEmpty()) {
                    maxArea = Math.max(maxArea, height * i);
                } else {
                    maxArea = Math.max(maxArea, height * (i - deque.peekLast() - 1));
                }
            }
            deque.addLast(i);
        }

        while (!deque.isEmpty()) {
            int top = deque.removeLast();
            if (deque.isEmpty()) { // 说明刚刚移除的是最后一个元素，是最小的元素
                maxArea = Math.max(maxArea, heights.length * heights[top]);
            } else {
                int height = heights[top];
                while (!deque.isEmpty() && heights[deque.peekLast()] == height) {
                    deque.removeLast();
                }
                int area = height * (heights.length - (deque.isEmpty() ? 0 : deque.peekLast() + 1));
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        BetterSolution bs = new BetterSolution();
//        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {4,2,2,3,2,5};
        int[] heights = {3,6,5,7,4,8,1,0};
        System.out.println(bs.largestRectangleArea(heights));
    }
}
