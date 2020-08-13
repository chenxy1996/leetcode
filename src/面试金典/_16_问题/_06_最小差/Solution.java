package 面试金典._16_问题._06_最小差;

import java.util.Arrays;

public class Solution {
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int min = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        int val1 = 0, val2 = 0;
        while (p1 < a.length && p2 < b.length) {
            val1 = a[p1];
            val2 = b[p2];
            if (val1 < val2) {
                p1++;
            } else {
                p2++;
            }
            min = Math.min(min, Math.abs((val1 - val2) > Integer.MIN_VALUE ? val1 - val2 : Integer.MAX_VALUE));
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1,5,6,7,8,9,1034,56074,64397,1565,37663,8737,48,56,188,701,9278,64,66,68,838,2638,336,4818,85,4439,90,223,7788};
        int[] b = {62577,4977,5363,122};
        System.out.println(smallestDifference(a, b));
    }
}
