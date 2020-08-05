package 题目._438_典型滑动窗口_和30题类似_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.List;

/**
 * 典型的滑动窗口题目,
 * 初见受到 30 题目的影响，写得不行
 */
public class Solution {
    public List<Integer> findAnagram(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s == null || p == null) {
            return ans;
        }

        char[] scs = s.toCharArray();
        char[] pcs = p.toCharArray();


        int[] map = new int[26];
        for (char sc : pcs) {
            map[sc - 'a']++;
        }

        int pLen = pcs.length;
        int ptr = 0;
        while (ptr + pLen - 1 < s.length()) { // 闭区间
            int cnt = pLen;
            int[] record = new int[26];

            while (cnt > 0) {
                char c = scs[ptr + cnt - 1];
                record[c - 'a']++;
                if (record[c - 'a'] > map[c - 'a']) {
                    break;
                }
                cnt--;
            }

            if (cnt == 0) {
                ans.add(ptr);
            }

            ptr += Math.max(1, cnt - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "";
        String p = "b";
        System.out.println(solution.findAnagram(s, p));
    }
}
