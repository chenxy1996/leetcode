package 剑指offer二刷_20200806._13_机器人的运动范围;

public class Solution {
    private static boolean[][] visited;
    public static int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return move(m, n, k, 0, 0);
    }

    private static int move(int m, int n, int k, int x, int y) {
        if (x < m && y < n && bitSum(x) + bitSum(y) <= k && !visited[x][y]) {
            visited[x][y] = true;
            return 1 + move(m, n, k, x + 1, y) + move(m, n, k, x, y + 1);
        }
        return 0;
    }

    private static int bitSum(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 10;
            num = num / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitSum(28));
    }
}
