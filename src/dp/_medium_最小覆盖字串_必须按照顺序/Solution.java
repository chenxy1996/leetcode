package dp._medium_最小覆盖字串_必须按照顺序;

// s 的子串包含字串 t
// s 的子串可以不按照顺序
// s = abderfgn, t = rgn
// 返回 rfgn

/**
 * 这里用了动态规划,
 * 但是不太行
 */
public class Solution {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        if (t.length() == 1 && s.contains(t)) {
            return t;
        }

        int min = Integer.MAX_VALUE;
        String minWidow = "";

        int[] dp = new int[s.length()];

        char firstChar = t.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (firstChar == s.charAt(i)) {
                dp[i] = 1;
            }
        }

        for (int j = 1; j < t.length(); j++) {
            char c = t.charAt(j);
            int[] temp = new int[dp.length];

            for (int k = 0; k < dp.length; k++) {
                if (s.charAt(k) == c && k >= j) {
                    // s 的 第 k 位和 t 的第 j 位相等
                    int p = k - 1;
                    while (p >= 0) {
                        if (dp[p] > 0) {
                            temp[k] = dp[p] + k - p;

                            if (j == t.length() - 1) {
                                if (temp[k] < min) {
                                    min = temp[k];
                                    minWidow = s.substring(p - dp[p] + 1, k + 1);
                                }
                            }

                            break;
                        }
                        p--;
                    }
                }
            }

            dp = temp;
        }

//        System.out.println(minWidow);
        return minWidow;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "CB";

        System.out.println(minWindow(s, t));
    }
}
