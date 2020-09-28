package 网易.丢弃最少的物品;

public class Solution {
    static int ans = Integer.MAX_VALUE;

    private static void dfs(int[] nums, int p1, int p2, int i, int drop) {
        if (i >= nums.length) {
            if (p1 == p2) {
                ans = Math.min(ans, drop);
            }
            return;
        }

        dfs(nums, p1 + nums[i], p2, i + 1, drop);
        dfs(nums, p1, p2 + nums[i], i + 1, drop);
        dfs(nums, p1, p2, i + 1, drop + nums[i]);
    }

    private static int resolve(int[] nums) {
        dfs(nums, 0, 0, 0, 0);
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(resolve(new int[]{30, 60, 5, 15, 30}));
    }
}
