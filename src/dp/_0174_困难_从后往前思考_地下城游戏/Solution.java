package dp._0174_困难_从后往前思考_地下城游戏;

/**
 * 这里还是要转移思路，从左上到右边下面麻烦，所以选择从右下到左上的思路
 */
public class Solution {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int d = dungeon[i][j];
                int minB = Integer.MIN_VALUE;
                int minR = Integer.MIN_VALUE;
                if (i + 1 < m) {
                    // 下边的
                    int b = dungeon[i + 1][j] + d;
                    minB = Math.min(d, b);
                }
                if (j + 1 < n) {
                    // 右边的
                    int r = dungeon[i][j + 1] + d;
                    minR = Math.min(d, r);
                }
                int curr = Math.max(minB, minR);
                dungeon[i][j] = curr == Integer.MIN_VALUE ? d : curr;
            }
        }

        return dungeon[0][0] >= 0 ? 1 : -dungeon[0][0] + 1;
    }

    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
//        int[][] dungeon = {
//                {0, 0},
//        };
        System.out.println(calculateMinimumHP(dungeon));
    }
}
