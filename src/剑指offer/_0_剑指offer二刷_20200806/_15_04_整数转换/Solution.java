package 剑指offer._0_剑指offer二刷_20200806._15_04_整数转换;

/**
 * 输入两个整数 m 和 n , 计算需要改编 m 的二进制表示中的多少位才能得到 n 。
 */
public class Solution {
    public int convertIntegers(int m, int n) {
        int q = m ^ n;
        int ans = 0;
        while (q != 0) {
            ans ++;
            q &= q - 1;
        }
        return ans;
    }
}
