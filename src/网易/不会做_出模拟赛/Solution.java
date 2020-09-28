package 网易.不会做_出模拟赛;

public class Solution {
    private static int arrange(int[] nums) {
        int E = nums[0];
        int M = nums[2];
        int H = nums[4];

        int l = 0;
        int r = 0;
        for(int each : nums) {
            r += each;
        }

        int ans = Math.min(E, Math.min(M, H));

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (judge(nums, mid)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private static boolean judge(int[] nums, int k) {
        int E = nums[0];
        int EM = nums[1];
        int M = nums[2];
        int MH = nums[3];
        int H = nums[4];

        if (E < k) {
            EM -= (k - E);
            if (EM < 0) {
                return false;
            }
        }

        if (H < k) {
            MH -= k - H;
            if (MH < 0) {
                return false;
            }
        }

        if (EM + MH + M < k) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
