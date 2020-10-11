package 题目.岛屿最大面积;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] == -1 || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = -1;
        return 1 +
                dfs(grid, x - 1, y) +
                dfs(grid, x + 1, y) +
                dfs(grid, x, y - 1) +
                dfs(grid, x, y + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1}};
        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
