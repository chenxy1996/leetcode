package 剑指offer二刷_20200806._20_01_表示数值的字符串;

public class Solution {
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean dotSeen = false;
        boolean flagSeen = false;
        boolean numberSeen = false;
        boolean eSeen = false;

        s = s.strip();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '+' || c == '-') {
                if (flagSeen || numberSeen || dotSeen) {
                    return false;
                }
                flagSeen = true;
            } else if (c == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                flagSeen = false;
                numberSeen = false;
                dotSeen = false;
                eSeen = true;
            } else if (c >= '0' && c <= '9') {
                numberSeen = true;
            } else {
                return false;
            }
        }
        return numberSeen;
    }

    public static void main(String[] args) {
        String s = " 005047e+6";
        System.out.println(isNumber(s));
    }
}
