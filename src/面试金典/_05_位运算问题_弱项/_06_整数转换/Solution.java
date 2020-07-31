package 面试金典._05_位运算问题_弱项._06_整数转换;

public class Solution {
    public int convertInteger(int A, int B) {
        int res = 0;
        while (A != 0 | B != 0) {
            res += (A & 1) ^ (B & 1);
            A = A >>> 1;
            B = B >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 826966453;
        int b = -729934991;
        System.out.println(new Solution().convertInteger(a, b));
    }
}
