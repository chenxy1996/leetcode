package 剑指offer._43排列组合_感觉挺难的_1到n整数中1出现的次数_;

public class NoRecursionSolution {
    // 逐步统计每一位上1的出现次数
    public static int countDigitOne(int n) {
        int pow = 1;
        int res = 0;
        String s = String.valueOf(n);
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = c - '0';
            String highS = s.substring(0, i);
            int high = highS.length() > 0 ? Integer.parseInt(highS) : 0;
            String lowS = s.substring(i + 1);
            int low = lowS.length() > 0 ? Integer.parseInt(lowS) : 0;
            if (val == 0) {
                res += high * pow;
            } else if (val == 1) {
                res += high * pow + low + 1;
            } else {
                res += (high + 1) * pow;
            }
            pow *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(3));
    }
}
