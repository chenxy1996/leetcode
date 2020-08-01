package 题目._1513_仅含1的字串数;

public class Solution {
    public int numSub(String s) {
        int ans = 0;
        int ones = 0;
        int mod = (int) (Math.pow(10, 9) + 7);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                ones++;
                ans = (ans % mod + ones % mod) % mod;
            } else {
                ones = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1111011";
        System.out.println(new Solution().numSub(s));
    }
}
