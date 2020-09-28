package 旋转点._0033_搜索旋转数组中的某个数_无重复;

public class Solution {
    public int search(int[] nums, int target) {
        // 先找到旋转点
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        // 说明没有旋转（包括数组中只有一个元素）
        if (l == 0) {
            return search(nums, 0, nums.length - 1, target);
        }
        // 旋转点为 l = r
        // [0, l - 1], [l, nums.length - 1]
        if (target >= nums[0]) {
            return search(nums, 0, l - 1, target);
        } else {
            return search(nums, l, nums.length - 1, target);
        }
    }

    private int search(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) {
                return m;
            } else if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1};
        int target = 1;
        System.out.println(solution.search(nums, target));
    }
}
