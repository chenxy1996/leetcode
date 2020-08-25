package 滑动窗口.面试经典_16_02_变位词组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] stat = new int[26];
            for (char c : chars) {
                stat[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stat.length; i++) {
                if (stat[i] > 0) {
                    char c = (char) ('a' + i);
                    sb.append(c);
                    sb.append(stat[i]);
                }
            }
            map.computeIfAbsent(sb.toString(), a -> new LinkedList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"old", "her"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(s));
    }
}
