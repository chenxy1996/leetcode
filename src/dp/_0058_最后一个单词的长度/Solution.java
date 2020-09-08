package dp._0058_最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                ans++;
            }
        }
        return ans;
    }
}
