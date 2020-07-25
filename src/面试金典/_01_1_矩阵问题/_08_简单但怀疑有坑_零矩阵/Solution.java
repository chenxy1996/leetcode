package 面试金典._01_1_矩阵问题._08_简单但怀疑有坑_零矩阵;

import java.util.Arrays;

/**
 * 最简单的方法是很容易想出来的
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // 第一行和第一列作为其他行其他列 0 的投影标记
        int len = matrix[0].length;
        int wid = matrix.length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int i = 0; i < len; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < wid; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < wid; i++) {
            for (int j = 1; j < len; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    matrix[0][j] = 0; // 列标记为 0
                    matrix[i][0] = 0; // 行标记为 0
                }
            }
        }
        // 给列清零
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                clearColumn(i, matrix);
            }
        }
        // 给行清零
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                clearRow(i, matrix);
            }
        }

        if (firstRowHasZero) {
            clearRow(0, matrix);
        }

        if (firstColHasZero) {
            clearColumn(0, matrix);
        }
    }

    public void clearColumn(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public void clearRow(int row, int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,2,0,1},
            {3,4,5,2,0},
            {1,3,1,5,1}
        };
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
