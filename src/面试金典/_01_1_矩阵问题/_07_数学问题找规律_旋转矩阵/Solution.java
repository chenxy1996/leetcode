package 面试金典._01_字符串问题._07_数学问题找规律_旋转矩阵;

import java.util.Arrays;

public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix[0].length; // 边长
        int width = len; // 正方形边长
        int n = 0; // 从外往内数，第几个正方形
        while (width > 1) {
            for (int d = 0; d < width - 1; d++) {
                rotateFourPoint(d, n, matrix);
            }
            width -= 2;
            n++;
        }
    }

    private static void rotateFourPoint(int d, int n, int[][] matrix) {
        // len 为矩阵的宽度
        // n 为从矩阵从外往内数，第 n 个正方形
        // d 为离正方形左上角顶点的距离
        // 此时四个顶点的坐标分别为:
        // (n, n + d), (n + d, len - 1 - n), (len - 1 - n, len - 1 - n - d),
        // (len - 1 - n - d, n)
        int len = matrix.length;
        int x = len - 1 - n;
        int temp = matrix[n][n + d];
        matrix[n][n + d] = matrix[x - d][n];
        matrix[x - d][n] = matrix[x][x - d];
        matrix[x][x - d] = matrix[n + d][x];
        matrix[n + d][x] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        new Solution().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
