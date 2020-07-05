package jianZhiOffer._29hard_spiralOrder;

import java.util.Arrays;

public class OptimalSolution {
    // 根据四个界限（屏障）
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] res = new int[matrix.length * matrix[0].length];

        // 边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;

        int p = 0;

        while (true) {
            // 向左
            for (int i = left; i <= right; i++) {
                res[p++] = matrix[top][i];
            }
            // 上边界向内收缩1，加1
            ++top;
            if (top > down) {
                break;
            }

            // 向下
            for (int i = top; i <= down; i++) {
                res[p++] = matrix[i][right];
            }
            // 右边界向内收缩1，减1
            --right;
            if (left > right) {
                break;
            }

            // 向左
            for (int i = right; i >= left; i--) {
                res[p++] = matrix[down][i];
            }
            // 下边界向内收缩1，减1
            --down;
            if (top > down) {
                break;
            }

            // 向上
            for (int i = down; i >= top; i--) {
                res[p++] = matrix[i][left];
            }
            // 左边界向内收缩1，加1
            ++left;
            if (left > right) {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OptimalSolution solution = new OptimalSolution();

        int[][] matrix = new int[5][9];
        int number = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = number;
                number++;
            }
        }

        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }
}
