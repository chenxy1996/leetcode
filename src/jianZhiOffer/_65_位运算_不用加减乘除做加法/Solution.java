package jianZhiOffer._65_位运算_不用加减乘除做加法;

// 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

/**
 * 初见，写得比较啰嗦
 */
public class Solution {
    public static int add(int a, int b) {
        int upgrade = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int currBit;
            int bitA = a & 1;
            int bitB = b & 1;
            currBit = (bitA ^ bitB ^ upgrade) << i;
            if ((bitA == 1 && bitB == 1) ||
                    (upgrade == 1 && (bitA == 1 || bitB == 1))) {
                upgrade = 1;
            } else {
                upgrade = 0;
            }
            res = res | currBit;
            a = a >> 1;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = -123456776;
        int b = -20;
        System.out.println(add(a, b));
    }
}
