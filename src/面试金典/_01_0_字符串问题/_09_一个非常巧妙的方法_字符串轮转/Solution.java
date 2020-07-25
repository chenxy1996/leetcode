package 面试金典._01_0_字符串问题._09_一个非常巧妙的方法_字符串轮转;

/**
 * 要求：只调用一次检查字串的方法
 */
public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String ss = s2 + s2;
        return ss.contains(s1);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(new Solution().isFlipedString(s1, s2));
    }
}
