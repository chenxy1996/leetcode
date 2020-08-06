package 剑指offer._29hard_spiralOrder;

import java.util.Arrays;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        // 矩阵的宽
        int width = matrix[0].length;
        // 矩阵的高
        int height = matrix.length;

        int count = 0;
        int sum = width * height;

        int deltaWidth = 0;
        int deltaHeight = 0;
        int posX = 0;
        int posY = 0;

        int p = 0;
        int[] res = new int[sum];

        while (count < sum) {
            // 向右
            if (posX != 0 || posY != 0) {
                posY++;
            }
            for (int i = 0; i < width - deltaWidth && count < sum; i++) {
                res[p++] = matrix[posX][posY];
                posY++;
                count++;
            }
            posY--;
            deltaHeight++;

            // 向下
            posX++;
            for (int i = 0; i < height - deltaHeight && count < sum; i++) {
                res[p++] = matrix[posX][posY];
                posX++;
                count++;
            }
            posX--;
            deltaWidth++;

            // 向左
            posY--;
            for (int i = 0; i < width - deltaWidth && count < sum; i++) {
                res[p++] = matrix[posX][posY];
                posY--;
                count++;
            }
            posY++;
            deltaHeight++;


            // 向上
            posX--;
            for (int i = 0; i < height - deltaHeight && count < sum; i++) {
                res[p++] = matrix[posX][posY];
                posX--;
                count++;
            }
            posX++;
            deltaWidth++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

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
