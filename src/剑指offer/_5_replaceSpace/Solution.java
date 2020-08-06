package 剑指offer._5_replaceSpace;

public class Solution {
    public String replaceString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Solution().replaceString(s));
    }
}
