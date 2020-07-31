package 面试金典._05_位运算问题_弱项._03_中等_翻转数位;

public class Solution {
    public static int reverseBits(int num) {
        int max = 0;
        int left = 0;
        int right = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                left++;
            } else { // bit == 0
                max = Math.max(left + right + 1, max);
                right = left;
                left = 0;
            }
            num = num >>> 1;
        }
        max = Math.max(left + right + 1, max);
        return max;
    }

    public static void main(String[] args) {
//        int num = 1775;
        int num = 7;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(reverseBits(num));
    }
}
