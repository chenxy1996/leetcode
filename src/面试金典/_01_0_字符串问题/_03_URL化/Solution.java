package 面试金典._01_0_字符串问题._03_URL化;

// URL化。编写一种方法，将字符串中的空格全部替换为%20。
// 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
// （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
public class Solution {
    public String replaceSpaces(String S, int length) {
        char[] res = new char[length * 3];
        int p = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                res[p++] = '%';
                res[p++] = '2';
                res[p++] = '0';
            } else {
                res[p++] = c;
            }
        }
        return String.valueOf(res, 0, p);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Mr John Smith    ";
        int l = 13;
        System.out.println(solution.replaceSpaces(s, l));
    }
}
