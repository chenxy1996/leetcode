package 题目._438_典型_和30题类似_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.List;

public class RefinedOptimalSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null) {
            return ans;
        }
        char[] scs = s.toCharArray();
        char[] pcs = p.toCharArray();
        int sLen = scs.length;
        int pLen = pcs.length;

       int[] map = new int[26];
        for (char pc : pcs) {
            map[pc - 'a']++;
        }

        int i = 0;
        int j = 0;
        int cnt = 0;

        for(; j < sLen; j++) {
            char jc = scs[j];
            int ptrJ = jc - 'a';
            if (map[ptrJ] >= 1) {
                cnt++;
            }
            map[ptrJ]--;
            if (j >= pLen) {
                char ic = scs[i];
                int ptrI = ic - 'a';
                if (map[ptrI] >= 0) {
                    cnt--;
                }
                map[ptrI]++;
                i++;
            }
            if (cnt == pLen) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RefinedOptimalSolution solution = new RefinedOptimalSolution();
        String s = "cbaebabacd";
        String p = "abcd";
        System.out.println(solution.findAnagrams(s, p));
    }
}
