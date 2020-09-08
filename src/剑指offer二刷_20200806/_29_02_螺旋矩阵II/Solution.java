package 剑指offer二刷_20200806._29_02_螺旋矩阵II;

/**
 * 59 题
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 1;
        int l = 0, r = n - 1;
        int t = 0, b = n - 1;
        while (true) {
            // 从左往右
            for(int k = l; k <= r; k++) {
                ans[t][k] = i++;
            }
            t++;
            if (i > n * n) {
                break;
            }

            // 从上往下
            for(int k = t; k <= b; k++) {
                ans[k][r] = i++;
            }
            r--;
            if (i > n * n) {
                break;
            }

            // 从右往左
            for(int k = r; k >= l; k--) {
                ans[b][k] = i++;
            }
            b--;
            if (i > n * n) {
                break;
            }

            // 从下往上
            for(int k = b; k >= t; k--) {
                ans[k][l] = i++;
            }
            l++;
            if (i > n * n) {
                break;
            }
        }
        return ans;
    }
}
