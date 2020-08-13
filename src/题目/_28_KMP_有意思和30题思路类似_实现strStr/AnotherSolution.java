package 题目._28_KMP_有意思和30题思路类似_实现strStr;

public class AnotherSolution {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();

        long hash = 0;
        long nHash = 0;
        long module = 1L << 31;

        for (char c : ns) {
            nHash = nHash * 26 % module + (c - 'a');
        }

        long a = 1;
        for (int i = 0; i < ns.length; i++) {
            a = (a * 26) % module;
        }

        for (int i = 0; i < hs.length; i++) {
            char c = hs[i];
            if (i >= ns.length) {
                char pc = hs[i - ns.length];
                hash = (hash * 26 - (pc - 'a') * a + (c - 'a')) % module;
            } else {
                hash = (hash * 26 + (c - 'a')) % module;
            }

            if (i >= ns.length - 1 && hash == nHash) {
                return i - ns.length + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hayStack = "baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa";
        String needle = "bbaaaababa";


        System.out.println(strStr(hayStack, needle));
    }
}
