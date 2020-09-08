package 每日挑战._0712_174困难_从后往前思考_地下城游戏;

public class BetterSolution {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int d = dungeon[i][j];
                int b = i + 1 < m ? dungeon[i + 1][j] : Integer.MIN_VALUE;
                int r = j + 1 < n ? dungeon[i][j + 1] : Integer.MIN_VALUE;
                int max = Math.max(b, r);
                max = max == Integer.MIN_VALUE ? 0 : max;
                if (d >= 0) {
                    dungeon[i][j] = max + d;
                } else {
                    dungeon[i][j] = Math.min(d, max + d);
                }
            }
        }

        return dungeon[0][0] >= 0 ? 1 : -dungeon[0][0] + 1;
    }
}
