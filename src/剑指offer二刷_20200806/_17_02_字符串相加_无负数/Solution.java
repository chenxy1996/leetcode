package 剑指offer二刷_20200806._17_02_字符串相加_无负数;

public class Solution {
    public static String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();

        char[] ans = new char[len1 > len2 ? len1 + 1 : len2 + 1];

        int i = len1 - 1;
        int j = len2 - 1;
        int carry = 0;

        int p = ans.length - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) {
                sum += num1Chars[i--] - '0';
            }
            if (j >= 0) {
                sum += num2Chars[j--] - '0';
            }
            carry = sum / 10;
            ans[p--] = (char) ((sum % 10) + '0');
        }

        return ans[0] == 0 ? String.valueOf(ans, 1, ans.length - 1) :
                                String.valueOf(ans);
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "9";
        System.out.println(addStrings(a, b));
    }
}
