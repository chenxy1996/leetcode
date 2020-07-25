package 面试金典._01_0_字符串问题._06_字符串压缩;

// 字符串压缩。利用字符重复出现的次数，编写一种方法，
// 实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
// 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中
// 只包含大小写英文字母（a至z）。
public class Solution {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char cr = S.charAt(0);
        int count = 1;
        for (int i = 1; i <= S.length(); i++) {
            char c = 0;
            if (i == S.length() || (c = S.charAt(i)) != cr) {
                sb.append(cr);
                sb.append(count);
                cr = c;
                count = 1;
            } else {
                count++;
            }
        }
        return sb.length() < S.length() ? sb.toString() : S;
    }

    public static void main(String[] args) {
        String s = "abbccd";
        System.out.println(new Solution().compressString(s));
    }
}
