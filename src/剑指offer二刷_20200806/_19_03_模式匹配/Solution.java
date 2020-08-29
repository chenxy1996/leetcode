package 剑指offer二刷_20200806._19_03_模式匹配;

/**
 * 面试金典 16.18
 *
 * 写得不是很好，速度慢
 */
public class Solution {
    public static boolean patternMatching(String pattern, String value) {
        if (pattern == null || value == null) {
            return false;
        }
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        if (value.length() == 0) {
            return pattern.length() == 1;
        }

        char[] p = pattern.toCharArray();
        int aCnt = 0;
        int bCnt = 0;
        boolean swap = p[0] == 'b';
        for (int i = 0; i < p.length; i++) {
            char c = p[i];
            if (c == 'a') {
                aCnt++;
            } else {
                bCnt++;
            }
            if (swap) {
                p[i] = c == 'a' ? 'b' : 'a';
            }
        }
        if (swap) {
            int tmp = aCnt;
            aCnt = bCnt;
            bCnt = tmp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= value.length(); i++) {
            sb.delete(0, sb.length());
            String a = value.substring(0, i);

            int ptr = 0;
            while (ptr < p.length && p[ptr] == 'a') {
                sb.append(a);
                ptr++;
            }

            if (bCnt == 0) {
                if (sb.length() == value.length()) {
                    return sb.toString().equals(value);
                }
            } else {
                int start = sb.length();

                for (int j = start; j <= value.length(); j++) {
                    String b = value.substring(start, j);

                    if (!b.equals(a)) {
                        if (a.length() * aCnt + b.length() * bCnt == value.length()) {
                            sb.delete(start, sb.length());

                            while (ptr < p.length) {
                                if (p[ptr] == 'a') {
                                    sb.append(a);
                                } else {
                                    sb.append(b);
                                }
                                ptr++;
                            }

                            if (sb.toString().equals(value)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String value = "dogcatcatdog";
        String pattern = "abba";
        System.out.println(patternMatching(pattern, value));
    }
}
