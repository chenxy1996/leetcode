package 题目._84_困难_柱状图中的最大矩形;

/**
 * 最容易想到的方法，可能会超时
 * 结果：勉强通过
 */
public class FirstSolution {

    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                width = Math.min(width, heights[j]);
                max = Math.max(max, width * (i - j + 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FirstSolution fs = new FirstSolution();
        int[] heights = {2};
        System.out.println(fs.largestRectangleArea(heights));
    }
}
