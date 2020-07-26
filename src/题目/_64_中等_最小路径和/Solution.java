package 题目._64_中等_最小路径和;

public class Solution {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int l, u;
                if (j - 1 >= 0) {
                    l = grid[i][j - 1];
                } else {
                    l = Integer.MAX_VALUE;
                }
                if(i - 1 >= 0) {
                    u = grid[i - 1][j];
                } else {
                    u = Integer.MAX_VALUE;
                }
                int min = Math.min(u, l);
                if (min != Integer.MAX_VALUE) {
                    grid[i][j] += min;
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(nums));
    }
}
