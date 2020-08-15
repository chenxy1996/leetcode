package 剑指offer._0_剑指offer二刷_20200806._15_01_EXCEL表格编号;

/**
 * 168 题
 */
public class Solution {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n - 1 >= 0) {
            int rem = (n - 1) % 26;
            n = (n - 1) / 26;
            char c = (char) (rem + 'A');
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
}
