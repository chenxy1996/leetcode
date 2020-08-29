package 剑指offer二刷_20200806._05_01_替换空格;

public class Solution {
    public String replaceSpace(String s) {
        // 用书中想要我们使用的办法
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int blankCount = 0;
        for (char aChar : chars) {
            if  (aChar == ' ') {
                blankCount++;
            }
        }
        char[] newChars = new char[chars.length + 2 * blankCount];
        System.arraycopy(chars, 0, newChars, 0, chars.length);
        int i = chars.length - 1;
        int j = newChars.length - 1;
        while (i < j) {
            char c = newChars[i];
            if (c != ' ') {
                newChars[j] = newChars[i];
                j--;
            } else {
                newChars[j] = '0';
                newChars[j - 1] = '2';
                newChars[j - 2] = '%';
                j = j - 3;
            }
            i--;
        }
        return String.valueOf(newChars);
    }
}
