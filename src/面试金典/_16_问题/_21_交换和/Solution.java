package 面试金典._16_问题._21_交换和;

import java.util.Arrays;

public class Solution {
    public static int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i : array1) {
            sum1 += i;
        }
        for (int i : array2) {
            sum2 += i;
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        int delta = sum2 - sum1;
        if ((delta & 1) == 1) {
            return new int[0];
        }

        int p1 = 0;
        int p2 = 0;
        while (p1 < array1.length && p2 < array2.length) {
            int val1 = array1[p1];
            int val2 = array2[p2];
            if (val2 - val1 == delta / 2) {
                return new int[] {val1, val2};
            } else if (val2 - val1 < delta / 2) {
                p2++;
            } else {
                p1++;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] array1 = {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] array2 = {52, 20, 78, 50, 38, 96, 81, 20};
        System.out.println(Arrays.toString(findSwapValues(array1, array2)));
    }
}
