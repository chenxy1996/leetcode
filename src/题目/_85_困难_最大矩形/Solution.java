package 题目._85_困难_最大矩形;

import java.util.Arrays;

/**
 * 初见
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return 0;
        }
        // 新建一个矩阵记录 matrix 中每个点左边，上边连续的 1 的个数，包括自己
        int m = matrix.length;
        int n = matrix[0].length;
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = matrix[i][j];
                if (c == '0') {
                    dp[i][j] = new int[]{0, 0};
                } else {
                    dp[i][j][0] = 1 + (j >= 1 ? dp[i][j - 1][0] : 0); // 左边1个数
                    dp[i][j][1] = 1 + (i >= 1 ? dp[i - 1][j][1] : 0); // 上边1个数
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = dp[i][j][0];
                int y = dp[i][j][1];
                // 以该点所在行为起点，向上拓展行
                int width = Integer.MAX_VALUE;
                for (int k = 0; k < y; k++) {
                    int row = i - k;
                    width = Math.min(width, dp[row][j][0]);
                    int area = (k + 1) * width;
                    max = Math.max(max, area);
                }
                // 以该点所在列为起点，向左拓展列
                int height = Integer.MAX_VALUE;
                for (int k = 0; k < x; k++) {
                    int col = j - k;
                    height = Math.min(height, dp[i][col][1]);
                    int area = (k + 1) * height;
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
          {'1','0','1','1','0'},
          {'1','0','1','1','1'},
          {'1','1','1','1','1'},
          {'1','0','1','1','0'}
        };
        System.out.println(solution.maximalRectangle(matrix));
    }
}
