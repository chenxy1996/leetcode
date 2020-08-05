package 题目._74_搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
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
}
