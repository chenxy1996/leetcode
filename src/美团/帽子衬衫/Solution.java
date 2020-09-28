package 美团.帽子衬衫;

import java.util.PriorityQueue;

public class Solution {
    private static void maxProfit(int[] nums, int e, int f, int g) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(e);
        queue.add(f);
        queue.add(g);

        int profit = 0;
        for(int i = 0; i < 3 && nums[3] != 0; i++) {
            int max = queue.remove();
            int p;
            if (max == e) {
                p = 0;
            } else if (max == f) {
                p = 1;
            } else {
                p = 2;
            }
            profit += Math.min(nums[p], nums[3]) * max;
            nums[3] = Math.max(0, nums[3] - nums[p]);
        }

        System.out.println(profit);
    }

    public static void Main(String[] args) {
        int[] nums = {2, 3, 4, 5};
        int e = 6;
        int f = 7;
        int g = 8;
        maxProfit(nums, e, f, g);
    }
}
