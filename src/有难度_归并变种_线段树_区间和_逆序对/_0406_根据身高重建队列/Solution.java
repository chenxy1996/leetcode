package 有难度_逆序对._0406_根据身高重建队列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for(int[] each : people) {
            list.add(each[1], each);
        }
        return list.toArray(int[][]::new);
    }
}
