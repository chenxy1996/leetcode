package 面试金典._08_递归问题._05_中等_递归乘法;

public class Solution {
    public static int multiply(int A, int B) {
        int n = 1;
        int res = A;
        while (2 * n <= B) {
            res = res << 1;
            n = 2 * n;
        }
        return B == n ? res : res + multiply(A, B - n);
    }

    public static void main(String[] args) {
        System.out.println(multiply(1, 10));
    }
}
