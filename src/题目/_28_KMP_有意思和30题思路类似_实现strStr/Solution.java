package 题目._28_有意思和30题思路类似_实现strStr;

// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
// 出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//
public class Solution {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) {
            return 0;
        }
        int nLen = needle.length();
        int hLen = haystack.length();
        if (nLen > hLen) {
            return -1;
        }

        for (int i = 0; i < hLen - nLen + 1; i++) {
            int p = 0;
            while (p < nLen && haystack.charAt(i + p) == needle.charAt(p)) {
                p++;
            }
            if (p == nLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hayStack = "a";
        String needle = "a";
        System.out.println(strStr(hayStack, needle));
    }
}