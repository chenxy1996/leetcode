package 面试金典._10_数组问题._01_合并排序的数组;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int p = A.length - 1;
        while (i >= 0 && j >= 0) {
            int valA = A[i];
            int valB = B[j];
            if (valA >= valB) {
                A[p] = valA;
                i--;
            } else {
                A[p] = valB;
                j--;
            }
            p--;
        }
        while (j >= 0) {
            A[p] = B[j];
            p--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 0};
        int[] B = {2, 3, 7};
        Solution solution = new Solution();
        solution.merge(A, 1, B, 3);
        System.out.println(Arrays.toString(A));
    }
}
