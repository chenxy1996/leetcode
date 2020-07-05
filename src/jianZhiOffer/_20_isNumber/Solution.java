package jianZhiOffer._20_isNumber;

public class Solution {
    public boolean isNumber(String s) {
        // 去掉首尾的空格
        s = s.trim();
        char c;

        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if ('0' <= c && c <= '9') {
                // 如果是数字
                numSeen = true;
            } else if (c == 'e' || c == 'E') {
                // 如果是 e 那么前面就不能出现 e，而且必须有数字
                if (eSeen || !numSeen) {
                    return false;
                }
                // 重置之前的 numSeen
                numSeen = false;
                eSeen = true;
            } else if (c == '+' || c == '-') {
                // 如果是 + 或者 - , 那么就只能是第一个或者前一个为 e
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // 如果是 . , 那么前面就不能有 . 和 e
                if (dotSeen || eSeen) {
                    return false;
                }

                dotSeen = true;
            } else {
                // 出现其它字符
                return false;
            }
        }

        return numSeen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("6e6.5"));
    }
}
