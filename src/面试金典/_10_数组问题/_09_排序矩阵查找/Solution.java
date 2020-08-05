package 面试金典._10_数组问题._09_排序矩阵查找;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int len = height * width;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            int val = matrix[m / width][m % width];
            if (val == target) {
                return true;
            } else if (val < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {1, 4, 7, 11, 15},
                            {2, 5, 8, 12, 19},
                            {3, 6, 9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}
                        };
        int target = 8;
        System.out.println(searchMatrix(matrix, target));
    }
}
