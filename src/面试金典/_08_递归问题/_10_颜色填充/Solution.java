package 面试金典._08_递归问题._10_颜色填充;

import java.util.Arrays;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        if (newColor != initColor) {
            fill(image, sr, sc, newColor, initColor);
        }
        return image;
    }

    private void fill(int[][] image, int x, int y, int newColor, int initColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] == initColor) {
            image[x][y] = newColor;
            fill(image, x - 1, y, newColor, initColor);
            fill(image, x + 1, y, newColor, initColor);
            fill(image, x, y - 1, newColor, initColor);
            fill(image, x, y + 1, newColor, initColor);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = {
                {0,0,0},
                {0,1,1},
        };
        int newColor = 1;
        int sr = 1;
        int sc = 1;
        System.out.println(Arrays.deepToString(solution.floodFill(image, sr, sc, newColor)));
    }
}
