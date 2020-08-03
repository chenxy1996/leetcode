package 面试金典._08_递归问题._14_布尔运算;

public class Solution {
    public int countEval(String s, int result) {
        if (s.length() == 1) {
            return s.charAt(0) - '0' == result ? 1 : 0;
        }
        int operand = s.charAt(0) - '0';
        int ans = 0;
        char op = s.charAt(1);
        if (op == '&') {
            if (operand == 0 && result == 0) {
                ans += countEval(s.substring(2), 0)+ countEval(s.substring(2), 1);
            }
        } else if (op == '|') {
            if (operand == 1) {
                ans += countEval(s.substring(2), 0)+ countEval(s.substring(2), 1);
            } else {
                ans += countEval(s.substring(2), 1);
            }
        } else if (op == '^') {
            if (result == 0) {
                ans += countEval(s.substring(2), operand == 1 ? 1 : 0);
            } else {
                ans += countEval(s.substring(2), operand == 1 ? 0 : 1);
            }
        }

        return ans;
    }

    private int evalHelper(String s, int operand, char op, int res) {

    }

    private int eval(String s) {
        int o1 = s.charAt(0) - '0';
        char op = s.charAt(1);
        int o2 = s.charAt(2) - '0';
        if (op == '&') {
            return o1 & o2;
        } else if (op == '|') {
            return o1 | o2;
        } else {
            return o1 ^ o2;
        }
    }
}
