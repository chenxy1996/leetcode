package 题目._438_典型滑动窗口_和30题类似_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用滑动窗口来做
 */
public class OptimalSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null) {
            return ans;
        }
        char[] scs = s.toCharArray();
        char[] pcs = p.toCharArray();
        int pLen = pcs.length;
        int sLen = scs.length;

        int[] map = new int[26];
        for (char pc : pcs) {
            map[pc - 'a']++;
        }

        int i = 0;
        int j = 0;
        int[] seen = new int[26];

        for (; j < sLen; j++) {
            char jc = scs[j];
            int ptr = jc - 'a';
            seen[ptr]++;
            while (seen[ptr] > map[ptr]) {
                char ic = scs[i];
                seen[ic - 'a']--;
                i++;
            }
            if (j - i == pLen - 1) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        OptimalSolution os = new OptimalSolution();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(os.findAnagrams(s, p));
    }
}
