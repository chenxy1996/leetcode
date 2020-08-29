package 题目._1383_最小堆_困难_最大的团队表现值;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] combine = new int[n][2];
        for(int i = 0; i < n; i++) {
            combine[i][0] = efficiency[i];
            combine[i][1] = speed[i];
        }
        Arrays.sort(combine, (a, b) -> b[0]- a[0]);
        Queue<Integer> heap = new PriorityQueue<>();
        long sum = 0;
        long res = 0;
        for(int i = 0; i < n; i++) {
            if (heap.size() > k - 1) {
                sum -= heap.remove();
            }
            sum += combine[i][1];
            res = Math.max(res, sum * combine[i][0]);
            heap.add(combine[i][1]);
        }
        return (int) (res % ((int)(1e9 + 7)));
    }

    public static void main(String[] args) {
        System.out.println(1e9 + 7);
        int[] speed = {2,8,2};
        int[] efficiency = {2,7,1};
        int n = speed.length;
        int k = 2;
        System.out.println(maxPerformance(n, speed, efficiency, k));
    }
}
