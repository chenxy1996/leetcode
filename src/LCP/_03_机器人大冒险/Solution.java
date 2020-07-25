package LCP._03_机器人大冒险;

// 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，
// 机器人就会无限循环这条指令的步骤进行移动。指令有两种：
// U: 向y轴正方向移动一格
// R: 向x轴正方向移动一格。
//不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
//给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。

/**
 * 初见是想一个一个迭代出每一步的坐标，然后比较看会不会撞到，但这道题给的范围极大，会超时
 */
public class Solution {
    private String command;
    private int uCount = 0;
    private int rCount = 0;
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        init(command);
        if (!reachEntry(x, y)) {
            return false;
        }
        for (int[] obstacle : obstacles) {
            int x1 = obstacle[0];
            int y1 = obstacle[1];
            if (x1 <= x && y1 <= y && reachEntry(x1, y1)) {
                return false;
            }
        }
        return true;
    }

    private void init(String command) {
        this.command = command;
        // 统计 command 中有多少个 U 和 多少个 R
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                uCount++;
            } else {
                rCount++;
            }
        }
    }

    private boolean reachEntry(int x, int y) {
        int e1 = x / rCount;
        int e2 = y / uCount;
        int e = Math.min(e1, e2); // 此时已经执行了指令集 e 次
        int xp = rCount * e;
        int yp = uCount * e;
        int i = 0;
        while (xp <= x && yp <= y && i < command.length()) {
            if (xp == x && yp == y) {
                return true;
            }
            char c = command.charAt(i);
            if (c == 'U') {
                yp++;
            } else {
                xp++;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String command = "URR";
        int x = 3, y = 2;
        int[][] obstacles = {
                {4, 2}
        };
        System.out.println(solution.robot(command, obstacles, x, y));
    }
}
