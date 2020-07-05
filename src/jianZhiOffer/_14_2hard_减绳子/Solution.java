package jianZhiOffer._14_2hard_减绳子;

public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        long res = 1;
        int m = 1000000007;

        while (n >= 5) {
            res = res * 3 % m;
            n = n - 3;
        }

        return (int) (res * n % m);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(120));
    }
}
