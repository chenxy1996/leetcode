package 面试金典._16_问题._16_逆序对_我觉得挺难的_部分排序;

import java.util.Arrays;

public class Solution {
    public static int[] subSort(int[] array) {
        int[] ans = new int[] {-1, -1};
        int len = array.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int val = array[i];
            if (val < max) {
                ans[1] = i;
            } else {
                max = val;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int val = array[i];
            if (val > min) {
                ans[0] = i;
            } else {
                min = val;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(subSort(nums)));
    }
}
