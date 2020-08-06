package 剑指offer._43排列组合_感觉挺难的_1到n整数中1出现的次数_;

//f(n))函数的意思是1～n这n个整数的十进制表示中1出现的次数，将n拆分为两部分，最高一位的数字high和其他位的数字last，分别判断情况后将结果相加，看例子更加简单。
//
//        例子如n=1234，high=1, pow=1000, last=234
//
//        可以将数字范围分成两部分1~999和1000~1234
//
//        1~999这个范围1的个数是f(pow-1)
//        1000~1234这个范围1的个数需要分为两部分：
//        千分位是1的个数：千分位为1的个数刚好就是234+1(last+1)，注意，这儿只看千分位，不看其他位
//        其他位是1的个数：即是234中出现1的个数，为f(last)
//        所以全部加起来是f(pow-1) + last + 1 + f(last);
//
//        例子如3234，high=3, pow=1000, last=234
//
//        可以将数字范围分成两部分1~999，1000~1999，2000~2999和3000~3234
//
//        1~999这个范围1的个数是f(pow-1)
//        1000~1999这个范围1的个数需要分为两部分：
//        千分位是1的个数：千分位为1的个数刚好就是pow，注意，这儿只看千分位，不看其他位
//        其他位是1的个数：即是999中出现1的个数，为f(pow-1)
//        2000~2999这个范围1的个数是f(pow-1)
//        3000~3234这个范围1的个数是f(last)
//        所以全部加起来是pow + high*f(pow-1) + f(last);

public class Solution {
    // 递归
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n >= 1 && n <= 9) {
            return 1;
        }
        // 此时 n 至少有两位数
        // 获得最高位
        int leftmost = getHighestBitNumber(n);
        int pow = (int) Math.pow(10,getBitsNumber(n) - 1);
        int last = n - pow * leftmost;
        if (leftmost > 1) {
            // 最左边的数字不为1, 那么是大于1的
            return pow + // 1开头数字的总数
                    leftmost * countDigitOne(pow - 1) +
                        countDigitOne(last);
        } else {
            // 最左边的数字为1
            return last + 1 + // 1开头数字的总数
                    countDigitOne(last) +
                        countDigitOne(pow - 1);
        }
    }

    private static int getHighestBitNumber(int x) {
        while (x >= 10) {
            x = x / 10;
        }
        return x;
    }

    private static int getBitsNumber(int x) {
        int count = 0;
        while (x > 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 11;
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(21));
    }
}
