package jianZhiOffer._67_把字符串转换成整数;

/**
 * 对于会越界的问题，一律将正数转换为负数
 */
public class Solution {
    public int strToInt(String str) {
        int p = 0;
        int len = str.length();
        char c = '0';
        int res = 0;
        boolean isMinus = false;
        // 去除开头的空格
        while (p < len && ((c = str.charAt(p)) == ' ')) {
            p++;
        }
        // 取出后的第一个字符
        // 判断此时 p 指向的字符是不是 '+', '-';
        if (c == '-') {
            isMinus = true;
        } else if (c == '+') {
            isMinus = false;
        } else if (isDigit(c)) {
            res -= c - '0';
        } else {
            return res;
        }
        p++;
        while (p < len && (isDigit(c = str.charAt(p)))) {
            if (Integer.MIN_VALUE / 10 > res) {
                res = Integer.MIN_VALUE;
                break;
            } else {
                res = 10 * res;
            }
            int delta = c - '0';
            // 一定要判断 res < 0,res 为 0 时候，res - Integer.MIN_VALUE 会溢出
            if ((res < 0) && (res - Integer.MIN_VALUE <= delta)) {
                res = Integer.MIN_VALUE;
                break;
            } else {
                res -= delta;
            }
            p++;
        }

        if (!isMinus) {
            if (res == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -res;
        }
        return res;
    }

    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
//        Solution solution = new Solution();
//        String s = "-6147483648";
//        System.out.println(solution.strToInt(s));
    }
}
