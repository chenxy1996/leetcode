package 每日挑战._0712_174困难_从后往前思考_地下城游戏;

public class OptimalSolution {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int d = dungeon[i][j];
                if (i == m - 1 && j == n - 1) {
                    // 如果处在最右下格子
                    dungeon [i][j] = -d;
                } else if (j == n - 1) {
                    // 如果处在最右一列
                    dungeon[i][j] = dungeon[i + 1][j] - d;
                } else if (i == m - 1) {
                    // 如果处在最下一行
                    dungeon[i][j] = dungeon[i][j + 1] - d;
                } else {
                    dungeon[i][j] = Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - d;
                }
                if (dungeon[i][j] < 0) {
                    dungeon[i][j] = 0;
                }
            }
        }
        return dungeon[0][0] + 1;
    }

    public static void main(String[] args) {
//        int[][] dungeon = {
//                {-2, -3, 3},
//                {-5, -10, 1},
//                {10, 30, -5}
//        };
        int[][] dungeon = {
                {0, 0},
        };
        System.out.println(calculateMinimumHP(dungeon));
    }
}
