package 剑指offer._0_剑指offer二刷_20200806._04_二维数组中的查找;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x <= matrix.length - 1 && y >= 0) {
            int val = matrix[x][y];
            if (val == target) {
                return true;
            } else if (val < target) {
                x++;
            } else if (val > target) {
                y--;
            }
        }
        return false;
    }
}
