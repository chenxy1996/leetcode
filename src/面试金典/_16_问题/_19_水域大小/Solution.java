package 面试金典._16_问题._19_水域大小;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<Integer> ans = new ArrayList<>();

    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int val = land[i][j];
                if (val == 0) {
                    int size = search(land, i, j);
                    ans.add(size);
                }
            }
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for (Integer an : ans) {
            res[i++] = an;
        }
        Arrays.sort(res);
        return res;
    }

    private int search(int[][] land, int x, int y) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 0) {
            return 0;
        }
        land[x][y] = -1;
        return 1 + search(land, x - 1, y) + search(land, x + 1, y)
                + search(land, x, y - 1) + search(land, x, y + 1)
                + search(land, x - 1, y - 1) + search(land,x - 1, y + 1)
                + search(land, x + 1, y - 1) + search(land, x + 1, y + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] land = {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        System.out.println(Arrays.toString(solution.pondSizes(land)));
    }
}
