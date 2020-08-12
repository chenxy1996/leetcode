package 面试金典._16_数学问题._15_里面的map用的有意思_珠玑妙算;

public class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        int[] map = new int[26];
        for (int i = 0; i < 4; i++) {
            char sol = solution.charAt(i);
            char gue = guess.charAt(i);
            if (sol == gue) {
                ans[0]++;
            } else {
                if (map[sol - 'A'] < 0) {
                    ans[1]++;
                }
                map[sol - 'A']++;
                if (map[gue - 'A'] > 0) {
                    ans[1]++;
                }
                map[gue - 'A']--;
            }
        }
        return ans;
    }
}
