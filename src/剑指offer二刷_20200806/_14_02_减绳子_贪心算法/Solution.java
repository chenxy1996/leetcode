package 剑指offer二刷_20200806._14_02_减绳子_贪心算法;

public class Solution {
    public static int cuttingRopes(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        int module = 1000000008;
        while (n >= 5) {
            res  = res * 3 % module;
            n -= 3;
        }
        return (int) (n * res % module);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRopes(120));
    }
}
