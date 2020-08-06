package 剑指offer._47_礼物的最大价值;

public class OptimalSolution {
    /**
     * 直接在原来的 grid 二维数组中更改
     */
    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += Math.max(
                        j > 0 ? grid[i][j - 1] : 0, // 左边的
                        i > 0 ? grid[i - 1][j] : 0
                );
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
