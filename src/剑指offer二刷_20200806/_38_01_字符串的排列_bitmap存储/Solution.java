package 剑指offer二刷_20200806._38_字符串的排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ans = new ArrayList<>();

    public String[] permutation(String s) {
        char[] cs = s.toCharArray();
        permutation(cs, 0);
        return ans.toArray(String[]::new);
    }

    private void permutation(char[] cs, int i) {
        if (i == cs.length) {
            ans.add(String.valueOf(cs));
            return;
        }
        int bitmap = 0;
        for(int j = i; j < cs.length; j++) {
            char c = cs[j];
            int mask = 1 << (c - 'a');
            if ((mask & bitmap) == 0) {
                bitmap |= mask;
                swap(cs, i, j);
                permutation(cs, i + 1);
                swap(cs, i, j);
            }
        }
    }

    private void swap(char[] cs, int a, int b) {
        char temp = cs[a];
        cs[a] = cs[b];
        cs[b] = temp;
    }
}
