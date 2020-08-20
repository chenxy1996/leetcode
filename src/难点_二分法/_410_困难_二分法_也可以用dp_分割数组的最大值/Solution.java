package 题目._410_困难_二分法_也可以用dp_分割数组的最大值;

public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        long l = max;
        long r = sum;
        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (check(nums, mid, m)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    private boolean check(int[] nums, long sum, int m) {
        int cnt = 1; // 最后一次分割的时候没有加上，所以这次加上
        long s = 0;
        for(int i = 0; i < nums.length; i++) {
            if (s + nums[i] > sum) {
                cnt++;
                s = nums[i];
            } else {
                s += nums[i];
            }
        }
        return cnt > m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2147483647};
        int m = 2;
        System.out.println(solution.splitArray(nums, m));
    }
}
