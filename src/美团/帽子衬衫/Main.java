package 美团.帽子衬衫;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static void maxProfit(int[] nums, int e, int f, int g) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.add(e);
        queue.add(f);
        queue.add(g);

        long profit = 0;
        for(int i = 0; i < 3 && nums[3] != 0; i++) {
            long max = queue.remove();
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[4];
        for(int i = 0; i < 4; i++) {
            nums[i] = scanner.nextInt();
        }
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        int g = scanner.nextInt();
        maxProfit(nums, e, f, g);
    }
}
