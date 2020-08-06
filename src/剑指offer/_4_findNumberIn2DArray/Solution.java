package 剑指offer._4_findNumberIn2DArray;
//
//  [
//    [1,   4,  7, 11, 15],
//    [2,   5,  8, 12, 19],
//    [3,   6,  9, 16, 22],
//    [10, 13, 14, 17, 24],
//    [18, 21, 23, 26, 30]
//  ]
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;

        if ((matrix == null) || (n == 0)) {
            return false;
        }

        int m = matrix[0].length;

        // 选取矩阵右上角作为起点
        int i = 0;
        int j = m - 1;

        while (i <= n - 1 && j >= 0) {
            int curr = matrix[i][j];

            if (curr == target) {
                return true;
            }

            if (curr > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[] {1,   4,  7, 11, 15};
        matrix[1] = new int[] {2,   5,  8, 12, 19};
        matrix[2] = new int[] {3,   6,  9, 16, 22};
        matrix[3] = new int[] {10, 13, 14, 17, 24};
        matrix[4] = new int[] {18, 21, 23, 26, 30};

        int target = 14;

        System.out.println(new Solution().findNumberIn2DArray(matrix, target));
    }
}
