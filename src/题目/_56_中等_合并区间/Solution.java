package 题目._56_合并区间;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        int s = intervals[0][0];
        int e = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= e) {
                e = Math.max(intervals[i][1], e);
            } else {
                ans.add(new int[] {s, e});
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }
        ans.add(new int[] {s, e});
        int[][] res = new int[ans.size()][2];
        int p = 0;
        for(int[] each : ans) {
            res[p++] = each;
        }
        return res;
    }

    public static void main(String[] args) {
        //  [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = {
                {1,3},{2,6},{8,10}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
