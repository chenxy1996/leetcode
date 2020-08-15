package 剑指offer._0_剑指offer二刷_20200806._19_05_一次编辑;

/**
 * 面试金典 1.5
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class Solution {
    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        if (len1 < len2) {
            return oneEditAway(second, first);
        }
        if (len1 <= 1 && len2 == 0) {
            return true;
        }
        boolean res;
        if (first.charAt(0) == second.charAt(0)) { // 开头相等
            res = oneEditAway(first.substring(1, len1), second.substring(1, len2));
        } else { // 开头不相等
            res = first.substring(1, len1).equals(second.substring(1, len2));
        }
        res |= first.substring(1, len1).equals(second);
        return res;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(oneEditAway(a, b));
    }
}
