package 题目._85_困难_最大矩形;

public class RefinedSolution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = matrix[i][j];
                if (c == '1') {
                    dp[i][j] = 1 + (j >= 1 ? dp[i][j - 1] : 0);
                    max = Math.max(max, scanToTop(dp, i, j));
                }
            }
        }
        return max;
    }

    private int scanToTop(int[][] dp, int x, int y) {
        int max = 0;
        int width = Integer.MAX_VALUE;
        for (int i = x; i >= 0; i--) {
            if (dp[i][y] == 0) {
                break;
            } else {
                width = Math.min(width, dp[i][y]);
                max = Math.max(width * (x - i + 1), max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        RefinedSolution solution = new RefinedSolution();
        char[][] matrix = {
                {'1','0','0','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','0'}
        };
//        char[][] matrix = {
//                {'1','0'},
//                {'1','0'}
//        };
        System.out.println(solution.maximalRectangle(matrix));
    }
}
