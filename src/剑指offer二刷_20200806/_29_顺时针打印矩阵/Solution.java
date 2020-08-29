package 剑指offer二刷_20200806._29_顺时针打印矩阵;

import java.util.Arrays;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];

        int t = 0;
        int b = m - 1;
        int l = 0;
        int r = n - 1;

        int p = 0;

        while (true) {
            // 向右
            for(int i = l; i <= r; i++) {
                ans[p++] = matrix[t][i];
            }
            t++;
            if (p == m *n ) {
                break;
            }

            // 向下
            for(int i = t; i <= b; i++) {
                ans[p++] = matrix[i][r];
            }
            r--;
            if (p == m *n ) {
                break;
            }

            // 向左
            for(int i = r; i >= l; i--) {
                ans[p++] = matrix[b][i];
            }
            b--;
            if (p == m *n ) {
                break;
            }

            // 向上
            for(int i = b; i >= t; i--) {
                ans[p++] = matrix[i][l];
            }
            l++;
            if (p == m *n ) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(Arrays.toString(new Solution().spiralOrder(matrix)));
    }
}
