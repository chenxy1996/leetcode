package 题目._0067_二进制求和;

public class Solution {
    public static String addBinary(String a, String b) {
        char[] cs = new char[Math.max(a.length(), b.length()) + 1];
        int p = cs.length - 1;
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            int res = 0;
            if (i >= 0) {
                res += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                res += b.charAt(j--) - '0';
            }
            res += carry;
            cs[p--] = (res & 1) == 1 ? '1' : '0';
            carry = res >>> 1;
        }
        return cs[0] == 0 ? String.valueOf(cs, 1, cs.length - 1) : String.valueOf(cs);
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(addBinary(a, b));
    }
}
