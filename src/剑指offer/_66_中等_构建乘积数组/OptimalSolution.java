package 剑指offer._66_中等_构建乘积数组;

import java.util.Arrays;

public class OptimalSolution {
    public static int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = 1;
        }

        int temp1 = 1, temp2 = 1;
        for (int i = 0, p1 = len - 1, p2 = 0; i < len - 1; i++, p1--, p2++) {
            temp1 *= a[p1];
            temp2 *= a[p2];
            res[len - 2 - i] *= temp1;
            res[1 + i] *= temp2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(constructArr(nums)));
    }
}
