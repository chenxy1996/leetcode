package jianZhiOffer._44排列组合_Mdium_数字序列中某一位的数字;

public class Solution {
    public int findNthDigit(int n) {
        // 首先判断 n 所在位置代表的完整数字是多少位数
        int bits = 1;
        int lower = 0;
        int upper = 9;
        while (n > upper) {
            bits++;
            lower = upper + 1;
            upper += 9 * Math.pow(10, bits - 1) * bits;
        }
        // 判断该完整数字在相同位数中序号如 1001 为四位数字中序号为1(第2个)
        int pos = (n - lower) / bits;
        int rem = (n - lower) % bits;
        int num = bits == 1 ? pos : (int) (Math.pow(10, bits - 1) + pos);
        return String.valueOf(num).charAt(rem) - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(9));
    }
}
