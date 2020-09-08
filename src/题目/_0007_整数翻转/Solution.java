package 题目._0007_整数翻转;

public class Solution {
    public static int reverse(int x) {
        int flag = x >>> 31;
        long ans = 0;
        x = flag == 1 ? -x : x;
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        ans = flag == 1 ? -ans : ans;
        return ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE ? 0 : (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
}
