package 题目._63_不同路径2;

/**
 * 做麻烦了，可以用滚动一维数组做
 */
public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        format(obstacleGrid);
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == -1) {
                break;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }
        for(int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == -1) {
                break;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != -1) {
                    if (obstacleGrid[i - 1][j] != - 1) {
                        obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                    }
                    if (obstacleGrid[i][j - 1] != - 1) {
                        obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    private static void format(int[][] obstacleGrid) {
        for(int i = 0; i < obstacleGrid.length; i++) {
            for(int j = 0; j < obstacleGrid[0].length; j++) {
                obstacleGrid[i][j] = -obstacleGrid[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
