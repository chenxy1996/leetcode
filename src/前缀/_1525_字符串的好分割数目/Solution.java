package 前缀和._1525_字符串的好分割数目;

public class Solution {
    public static int numSplits(String s) {
        if (s == null) {
            return 0;
        }
        int[] fromLeft = new int[s.length()];
        boolean[] map = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            int p = s.charAt(i) - 'a';
            if (map[p] == false) {
                fromLeft[i] = i == 0 ? 1 : fromLeft[i - 1] + 1;
                map[p] = true;
            } else {
                fromLeft[i] = fromLeft[i - 1];
            }
        }
        int[] fromtRight = new int[s.length()];
        for(int i = s.length() - 1; i >= 0 ; i--) {
            int p = s.charAt(i) - 'a';
            if (map[p] == true) {
                fromtRight[i] = (i == s.length() - 1) ? 1 : fromtRight[i + 1] + 1;
                map[p] = false;
            } else {
                fromtRight[i] = fromtRight[i + 1];
            }
        }
        int ans = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            ans += fromLeft[i] == fromtRight[i + 1] ? 1 : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(numSplits(s));
    }
}
