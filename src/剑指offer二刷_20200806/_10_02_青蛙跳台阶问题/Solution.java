package 剑指offer二刷_20200806._10_02_青蛙跳台阶问题;

public class Solution {
    public int numWays(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 2; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
