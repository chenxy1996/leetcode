package 网易.丢弃最少的物品;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 错的
public class WrongSolution {
    private static int discard(int[] nums) {
        Queue<Integer> odds = new PriorityQueue<>();
        Queue<Integer> evens = new PriorityQueue<>();

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
            sum += nums[i];
        }

        if ((sum & 1) == 0) { // 可以丢弃两个奇数或者一个偶数
            int od = Integer.MAX_VALUE;
            int ed = Integer.MAX_VALUE;
            if (odds.size() > 1) {
                od = Math.min(od, odds.poll() + odds.poll());
            }
            if (evens.size() > 0) {
                ed = Math.min(ed, evens.poll());
            }
            return Math.min(od, ed);
        } else { // 丢弃一个最小的奇数
            return odds.poll();
        }
    }

    public static void main(String[] args) {

    }
}
