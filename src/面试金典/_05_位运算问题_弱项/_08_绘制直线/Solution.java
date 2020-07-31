package 面试金典._05_位运算问题_弱项._08_绘制直线;

import java.util.Arrays;

public class Solution {
    public static int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        int i = x1 / 32;
        int p = (w / 32) * y + i;
        while (x1 <= x2) {
            if (x2 > 31 + 32 * i && x1 >= 32 * i) {
                ans[p] = -1 >>> x1;
            } else {
                int cnt = x2 - x1 + 1;
                ans[p] = (-1 >>> (32 - cnt)) << (31 + 32 * i - x2);
            }
            i++;
            x1 = 32 * i;
            p++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int length = 15;
//        int w = 96;
//        int x1 = 81;
//        int x2 = 95;
//        int y = 1;
        int length = 1;
        int w = 32;
        int x1 = 30;
        int x2 = 31;
        int y = 0;
        System.out.println(Arrays.toString(drawLine(length, w, x1, x2, y)));
    }
}
