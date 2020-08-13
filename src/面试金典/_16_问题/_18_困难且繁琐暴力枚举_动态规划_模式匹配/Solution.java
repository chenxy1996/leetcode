package 面试金典._16_问题._18_困难且繁琐暴力枚举_动态规划_模式匹配;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像
 * "a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value
 * 字符串是否匹配pattern字符串。
 */
public class Solution {
    public static boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        if (value.length() == 0 ) {
            return pattern.length() == 1;
        }
        int aCount = 0;
        int bCount = 0;
        char[] patternChars = pattern.toCharArray();
        boolean swap = patternChars[0] == 'b';
        for (int i = 0; i < patternChars.length; i++) {
            char c = patternChars[i];
            if (c == 'a') {
                aCount++;
            } else {
                bCount++;
            }
            if (swap) {
                patternChars[i] = c == 'a' ? 'b' : 'a';
            }
        }
        if (swap) {
            int temp = aCount;
            aCount = bCount;
            bCount = temp;
        }

        for (int i = 0; i <= value.length(); i++) {
            String aString = value.substring(0, i);
            StringBuilder sb = new StringBuilder();
            sb.append(aString);
            int j = 1;
            while (j < patternChars.length && patternChars[j] == 'a') {
                 sb.append(aString);
                 j++;
            }
            if (bCount == 0) { // 说明 pattern 中没有 b 只有 a
                if (sb.toString().equals(value)) {
                    return true;
                }
            } else {
                int p = sb.length();
                for (int k = p; k <= value.length(); k++) {
                    String bString = value.substring(p, k);
                    if (!bString.equals(aString)) {
                        if (aCount * aString.length() + bCount * bString.length() != value.length()) {
                            continue;
                        }
                        int jj = j + 1;
                        StringBuilder sb1 = new StringBuilder(sb.toString());
                        sb1.append(bString);
                        while (jj < patternChars.length) {
                            if (patternChars[jj] == 'a') {
                                sb1.append(aString);
                            } else {
                                sb1.append(bString);
                            }
                            jj++;
                        }
                        if (sb1.toString().equals(value)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String pattern = "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbabbbb";
        String value = "yxankynynxnxnxxyxyyyxxakxanaxnankyykxxannxayyyaxakyyyxxyxyyxxkxyyyyxnxxyykayyanayxayknayxyyynyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyykxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyyxankynynxnxnxxyxyyyxxakxanaxnankyykxxannxayyyaxakyyyxxyxyyxxkxyyyyxnxxyykayyanayxayknayxyyynyxxykykyyxxykykyyxxxykykyy";
        System.out.println(patternMatching(pattern, value));
    }
}
