package 题目._1482_二分法_制作m束花所需的最少天数;

public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (len < m * k) {
            return -1;
        }
        int r = 0;
        for(int each : bloomDay) {
            r = Math.max(r, each);
        }
        int l = 1;
        while (l <= r) {
            int mid = (r -l) / 2 + l;
            if (canMake(bloomDay, mid, m, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canMake(int[] bloomDay, int d, int m, int k) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        while (right < bloomDay.length) {
            if (bloomDay[right] > d) {
                left = right + 1;
            }
            right++;
            if (right - left == k) {
                cnt++;
                left = right;
            }
        }
        return cnt >= m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(solution.minDays(bloomDay, m, k));
    }
}
