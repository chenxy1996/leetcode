<<<<<<< HEAD
package dfs._19hardhard_isMatch;

public class Solution {
    /**
     * 本题目可以用 dp 做，这次用递归做
     * 在 leetcode 中超出时间了
     * 但是可以做
     */
    public boolean isMatch(String s, String p) {
        // 边界条件
        // 最后 s 和 p 都为空字符串
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        // 1. 如果 s 和 p 开头字符相等, 该种情况字符肯定在 a ~ z 之中
        // 2. 或者 p 的开头是 .
        if ((s.length() > 0 && p.length() > 0) &&
                    (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            // 这两种情况下如果 p 的下一个字符是 '*'
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || // 不匹配当前字符
                            isMatch(s.substring(1), p.substring(2)) || // 匹配一个
                                isMatch(s.substring(1), p); // 匹配多个
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // 这种情况 p 和 s 字符在 a ~ z 之中 且 s 和 p 开头字符不相等
        // 但是 p 的下一个字符为 '*'
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        }

        return false;
    }

    public static void main(String[] args) {
//        String p = "..b*a*..*c";
//        String s = "ccacacc";

        String s = "aaaaaaaaaaaaab";
        String p  = "a*a*a*a*a*a*a*a*a*a*b";

        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}
=======
package dfs._19hardhard_isMatch;

public class Solution {
    /**
     * 本题目可以用 dp 做，这次用递归做
     * 在 leetcode 中超出时间了
     * 但是可以做
     */
    public boolean isMatch(String s, String p) {
        // 边界条件
        // 最后 s 和 p 都为空字符串
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        // 1. 如果 s 和 p 开头字符相等, 该种情况字符肯定在 a ~ z 之中
        // 2. 或者 p 的开头是 .
        if ((s.length() > 0 && p.length() > 0) &&
                    (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            // 这两种情况下如果 p 的下一个字符是 '*'
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || // 不匹配当前字符
                            isMatch(s.substring(1), p.substring(2)) || // 匹配一个
                                isMatch(s.substring(1), p); // 匹配多个
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // 这种情况 p 和 s 字符在 a ~ z 之中 且 s 和 p 开头字符不相等
        // 但是 p 的下一个字符为 '*'
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        }

        return false;
    }

    public static void main(String[] args) {
//        String p = "..b*a*..*c";
//        String s = "ccacacc";

        String s = "aaaaaaaaaaaaab";
        String p  = "a*a*a*a*a*a*a*a*a*a*b";

        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
