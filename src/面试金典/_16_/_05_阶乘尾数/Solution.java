package 面试金典._16_._05_阶乘尾数;

/**
 * 这个似乎是有 bug 的，数字很大后有偏差
 */
public class Solution {
    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; (i <= Integer.MAX_VALUE / 5) && i <= n; i *= 5) {
            ans += n / i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
    }
}
