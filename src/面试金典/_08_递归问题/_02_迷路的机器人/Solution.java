package 面试金典._08_递归问题._02_迷路的机器人;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> ans = new ArrayList<>();
        move(obstacleGrid, 0, 0, ans);
        return ans;
    }

    private static boolean move(int[][] obstacleGrid, int x, int y, List<List<Integer>> path) {
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1) {
            return false;
        }
        List<Integer> coordinate = List.of(x, y);
        path.add(coordinate);
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return true;
        }
        if (move(obstacleGrid, x, y + 1, path) ||
                move(obstacleGrid, x + 1, y, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        // 下面这个防止超时
        obstacleGrid[x][y] = 1;
        return false;
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,1,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(new Solution().pathWithObstacles(obstacleGrid));
    }
}
