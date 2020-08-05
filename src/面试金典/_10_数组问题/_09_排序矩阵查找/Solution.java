package 面试金典._10_数组问题._09_排序矩阵查找;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int posX = 0;
        int posY = width - 1;
        while (posX < height && posY >= 0) {
            int val = matrix[posX][posY];
            if (val == target) {
                return true;
            } else if (val < target) {
                posX++;
            } else {
                posY--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {1,3,5,7},
                            {10,11,16,20},
                            {23,30,34,50},
                        };
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }
}
