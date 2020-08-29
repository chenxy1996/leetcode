package 剑指offer二刷_20200806._10_01_斐波那契数列;

public class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int module = 1000000007;

        for(int i = 2; i <= n; i++) {
            int tmp = (a + b) % module;
            a = b;
            b = tmp;
        }

        return b;
    }
}
