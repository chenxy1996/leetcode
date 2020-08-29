package 题目._1405_贪心_我觉得挺难的_最长快乐字符串;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在结果字符串最后两个字符不一样的情况下，添加三个字符中剩余次数最多的；
 * 在结果字符串最后两个字符一样的情况下，添加与最后字符不一样的另外两个字符中剩余次数较多的。
 *
 * 一个一个的向上加
 */
public class Solution {
    public static String longestDiverseString(int a, int b, int c) {
        int[][] map = new int[][]{
                {0, a},
                {1, b},
                {2, c}
        };
        StringBuilder sb = new StringBuilder();
        char pc = '&';
        char ppc = '&';
        while (true) {
            // 排序
            Arrays.sort(map, Comparator.comparingInt((int[] x) -> x[1]).reversed());
            int p = 0;
            char ch = (char) (map[0][0] + 'a');
            int cnt = map[0][1];
            if (ch == pc && pc == ppc) {
                p = 1;
                ch =  (char) (map[1][0] + 'a');
                cnt = map[1][1];
            }
            if (cnt == 0) {
                break;
            }
            map[p][1]--;
            sb.append(ch);
            cnt--;
            ppc = pc;
            pc = ch;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(0,8,11));
    }
}
