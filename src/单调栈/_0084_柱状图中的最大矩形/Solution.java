package 单调栈._0084_柱状图中的最大矩形;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int len = heights.length;
        for(int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int p = stack.removeLast();
                int last = stack.isEmpty() ? -1 : stack.peekLast();
                ans = Math.max(ans, (i - last - 1) * heights[p]);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int p = stack.removeLast();
            int last = stack.isEmpty() ? -1 : stack.peekLast();
            ans = Math.max(ans, (len - p) * heights[p] + (p - last - 1) * heights[p]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {3,6,5,7,4,8,1,0};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
