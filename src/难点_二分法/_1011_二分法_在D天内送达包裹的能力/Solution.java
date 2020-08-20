package 题目._1011_二分法_在D天内送达包裹的能力;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int l = weights[0];
        for(int each : weights) {
            l = Math.max(each, l);
            sum += each;
        }
        int r = sum;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (canShip(weights, D, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean canShip(int[] weights, int D, int load) {
        int days = 1;
        int sum = 0;
        for(int each : weights) {
            if (sum + each > load) {
                sum = each;
                days++;
            } else {
                sum += each;
            }
        }
        return days <= D;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int D = 4;
        System.out.println(new Solution().shipWithinDays(weights, D));
    }
}
