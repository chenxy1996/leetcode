package dp.无重复字符的最长字串_可用双指针法;

public class DoublePointersSolution {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int currLen = 0;
        StringBuilder sb = new StringBuilder();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            int index;
            if ((index = sb.indexOf(String.valueOf(c))) != -1) {
                sb = sb.delete(0, index + 1);
                currLen = sb.length() + 1;
            } else {
                currLen += 1;
            }
            sb.append(c);
            max = Math.max(max, currLen);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
