package 难点_二分法._875_二分法_爱吃香蕉的珂珂;

/**
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，
 * 将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，
 * 从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，
 * 然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        long sum = 0;
        int r = piles[0];
        for(int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
            sum += piles[i];
        }
        long l = sum % H == 0 ? sum / H : sum / H + 1;
        while (l <= r) {
            long m = (r - l) / 2 + l;
            if (canEat(piles, m, H)) {
                r = (int) (m - 1);
            } else {
                l = m + 1;
            }
        }
        return (int) l;
    }

    private boolean canEat(int[] piles, long speed, int H) {
        int hours = 0;
        for(int each : piles) {
            hours += Math.ceil(each * 1.0 / speed);
        }
        return hours <= H;
    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int H = 6;
        System.out.println(new Solution().minEatingSpeed(piles, H));
    }
}
