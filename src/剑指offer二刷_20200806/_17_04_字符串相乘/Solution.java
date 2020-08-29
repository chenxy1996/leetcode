package 剑指offer二刷_20200806._17_04_字符串相乘;

public class Solution {
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int p = 0;
        int[] bag = new int[m + n];
        for(int i = n - 1; i >= 0; i--) {
            int a = num2.charAt(i) - '0';
            int k = p;
            for(int j = m - 1; j >= 0; j--) {
                int b = num1.charAt(j) - '0';
                int product = a * b;
                bag[k++] += product;
            }
            p++;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < m + n; i++) {
            int sum = bag[i] + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        sb = sb.reverse();
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        return i == sb.length() ? "0" : sb.substring(i);
    }
}
