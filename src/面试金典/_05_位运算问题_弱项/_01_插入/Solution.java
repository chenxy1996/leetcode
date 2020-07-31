package 面试金典._05_位运算问题_弱项._01_插入;

/**
 * 位处理
 */
public class Solution {
    public static int insertBits(int N, int M, int i, int j) {
        int low = (~(-1 << i)) & N; // N 的最低 i 位
//        System.out.println(Integer.toBinaryString(low));
        if (j == 31) {
            N = 0;
        } else {
            N = (~0 << (j + 1)) & N; // N 的最低 j 位全变为 0
        }
//        System.out.println(Integer.toBinaryString(N));
        M = M << i; // M 向做偏移 i 位
//        System.out.println(Integer.toBinaryString(M));
        N = N | M; // N 的 i 到 j 位 变为原来的 M
//        System.out.println(Integer.toBinaryString(N));
        N = N | low;
//        System.out.println(Integer.toBinaryString(N));
        return N;
    }

    public static void main(String[] args) {
//        int n = 1024;
//        int m = 19;
//        int i = 2;
//        int j = 6;
//        int num = -1 << 31;
//        System.out.println(Integer.toBinaryString(num));
        int n = 1143207437;
        int m = 1017033;
        int i = 11;
        int j = 31;
        System.out.println(insertBits(n, m, i, j));
    }
}
