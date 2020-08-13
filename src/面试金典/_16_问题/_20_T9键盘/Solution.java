package 面试金典._16_问题._20_T9键盘;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> getValidT9Words(String num, String[] words) {
        char[][] chars = {
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        int[] map = new int[26];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                char c = chars[i][j];
                map[c - 'a'] = i;
            }
        }
        List<String> ans = new ArrayList<>();
        char[] nums = num.toCharArray();
        for (String word : words) {
            int p = 0;
            boolean add = true;
            for (char c : word.toCharArray()) {
                int number = nums[p] - '0';
                if (number != map[c - 'a']) {
                    add = false;
                    break;
                }
                p++;
            }
            if (add) {
                ans.add(word);
            }
        }
        return ans;
    }
}
