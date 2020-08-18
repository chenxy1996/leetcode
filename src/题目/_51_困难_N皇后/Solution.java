package 题目._51_N皇后;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> ans = new ArrayList<>();

    // 全排列问题
    public List<List<String>> solveNQueens(int n) {
        int[] arrangement = new int[n];
        boolean[] map = new boolean[n];
        arrange(arrangement, 0, n, map);
        return ans;
    }

    private void arrange(int[] arrangement, int p, int n, boolean[] map) {
        if (n == p) {
            print(arrangement);
            return;
        }
        for(int i = 0; i < n; i++) {
            if (map[i] == false) {
                map[i] = true;
                arrangement[p] = i;
                if (check(arrangement, p)) {
                    arrange(arrangement, p + 1, n, map);
                }
                map[i] = false;
            }
        }
    }

    private boolean check(int[] arrangement, int p) {
        for(int i = 0; i < p; i++) {
            int delta = p - i;
            if (Math.abs(arrangement[p] - arrangement[i]) == delta) {
                return false;
            }
        }
        return true;
    }

    private void print(int[] arrangement) {
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < arrangement.length; i++) {
            char[] cs = new char[arrangement.length];
            for(int j = 0; j < arrangement.length; j++) {
                if (j == arrangement[i]) {
                    cs[j] = 'Q';
                } else {
                    cs[j] = '.';
                }
            }
            arr.add(String.valueOf(cs));
        }
        ans.add(arr);
    }
}
