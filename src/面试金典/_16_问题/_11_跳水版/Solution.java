package 面试金典._16_问题._11_跳水版;

import java.util.Arrays;

public class Solution {
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] ans;
        if (shorter != longer) {
            ans = new int[k + 1];
            for (int i = 0; i <= k; i++) {
                ans[i] = shorter * (k - i) + longer * i;
            }
        } else {
            ans = new int[] {k * shorter};
        }
        return ans;
    }

    public static void main(String[] args) {
        int shorter = 1;
        int longer = 1;
        int k = 100000;
        System.out.println(Arrays.toString(divingBoard(shorter, longer, k)));
    }
}
