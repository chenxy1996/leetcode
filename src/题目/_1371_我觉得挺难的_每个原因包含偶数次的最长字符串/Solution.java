package 题目._1371_我觉得挺难的_每个原因包含偶数次的最长字符串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int findTheLongestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        int[] records = new int[5];

        Map<Character, Integer> index = new HashMap<>();
        index.put('a', 0);
        index.put('e', 1);
        index.put('i', 2);
        index.put('o', 3);
        index.put('u', 4);

        Map<String, Integer> map = new HashMap<>();
        map.put("00000", -1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index.containsKey(c)) {
                int p = index.get(c);
                records[p] ^= 1;
            }
            StringBuilder sb = new StringBuilder();
            for(int each : records) {
                sb.append(each);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                ans = Math.max(ans, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestSubString("eleetminicoworoep"));
    }
}
