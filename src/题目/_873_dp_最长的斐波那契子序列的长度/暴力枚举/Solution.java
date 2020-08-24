package 题目._873_最长的斐波那契子序列的长度;

import java.util.Arrays;

public class Solution {
    public static int lenLongestFibSubseq(int[] A) {
        if (A == null) {
            return 0;
        }
        int max = 0;
        int length = A.length;
        for(int i = 0; i < length - 2; i++) {
            for(int j = i + 1; j < length - 1; j++) {
                int a = A[i];
                int b = A[j];
                int c = a + b;
                int k = j + 1;
                int temp = 0;
                while (k < length) {
                    int p = Arrays.binarySearch(A, k, length, c);
                    if (p < 0) {
                        break;
                    } else {
                        a = b;
                        b = c;
                        c = a + b;
                        k = p + 1;
                        if (temp == 0) {
                            temp = 3;
                        } else {
                            temp++;
                        }
                    }
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {2,4,7,8,9,10,14,15,18,23,32,50};
        System.out.println(lenLongestFibSubseq(A));
    }
}
