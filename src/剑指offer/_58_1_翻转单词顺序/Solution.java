package 剑指offer._58_1_翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int e = s.length() - 1;
        while (e >= 0) {
            // 去除空格
            while (e >= 0 && s.charAt(e) == ' ') {
                e--;
            }
            int i = e;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (i < e) {
                sb.append(s.substring(i + 1, e + 1) + " ");
            }
            e = i;
        }

        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world!  ";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s) + "::::");
    }
}
