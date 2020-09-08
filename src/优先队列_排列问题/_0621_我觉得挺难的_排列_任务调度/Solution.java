package 优先队列_排列问题._0621_我觉得挺难的_排列_任务调度;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 很巧妙，可以看看相关题解
 */
public class Solution {
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] map = new int[26];
        for(char t : tasks) {
            map[t - 'A']++;
        }
        Arrays.sort(map);
        int i = 25;
        int max = map[i--];
        int maxCount = 1;
        while (i >= 0 && map[i] != 0 && map[i] == max) {
            maxCount++;
            i--;
        }
        int ans = (max - 1) * (n + 1) +  maxCount;
        return Math.max(ans, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(tasks, 2));
    }
}
