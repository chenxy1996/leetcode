package 优先队列._0621_我觉得挺难的_排列_任务调度;

import java.util.Arrays;

public class Solution {
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char task : tasks) {
            map[task - 'A']++;
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(tasks, 2));
    }
}
