package 面试金典._01_字符串问题._05_我觉得挺难的_一次编辑;

/**
 * 初见没有想起来怎么做
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        // 如果 first 的长度与 second 的长度只差大于1，肯定无法匹配直接返回 false
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // 保证 first 的长度不小于 second 的长度, 如果小于交换
        if (first.length() < second.length()) {
            String temp = second;
            second = first;
            first = temp;
        }
        // 逐个判断 first 字符串和 second 字符串各个字符
        int i = 0;
        for (; i < second.length(); i++) {
            char cs = second.charAt(i);
            char cf = first.charAt(i);
            if (cs != cf) {
                break;
            }
        }
        // 此时 i 所指的位置，first 和 second 不同，有三种情况：
        // 1. first = pale, second = pal 时候 i = 3 此时 i == second.length()
        if(i == second.length()) {
            return true;
        }
        // 2. first = pale, second = ple 时候 i = 1 此时比较
        // first[i + 1:] 和 second[i:]
        if (first.substring(i + 1).equals(second.substring(i))) {
            return true;
        }
        // 3. first = pale, second = pxle 时候 i = 1 此时比较
        // first[i + 1:] 和 second[i + 1:]
        if (first.substring(i + 1).equals(second.substring(i + 1))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String first = "pal";
        String second = "pale";
        System.out.println(solution.oneEditAway(first, second));
    }
}
