package 网易.计算数组的最小和;

/**
 * 数组小和的定义如下：
 * 例如，数组s = [1, 3, 5, 2, 4, 6]，在s[0]的左边小于或等于s[0]的数的和为0；
 * 在s[1]的左边小于或等于s[1]的数的和为1；在s[2]的左边小于或等于s[2]的数的和为1+3=4；
 * 在s[3]的左边小于或等于s[3]的数的和为1；
 * 在s[4]的左边小于或等于s[4]的数的和为1+3+2=6；在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15。
 * 所以s的小和为0+1+4+1+6+15=27
 * 给定一个数组s，实现函数返回s的小和
 * [要求]
 * 时间复杂度为O(nlogn)，空间复杂度为O(n)
 */
public class Solution {
    // 归并二分
    public static int getMinSum(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private static int merge(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int m = (r - l) / 2 + l;
        int leftSum = merge(nums, l, m);
        int rightSum = merge(nums, m + 1, r);
        int sum = 0;


        int i = l;
        int j = m + 1;
        int[] temp = new int[r - l + 1];
        int p = 0;

        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                sum += nums[i] * (r - j + 1);
                temp[p++] = nums[i++];
            } else {
                temp[p++] = nums[j++];
            }
        }

        while (i <= m) {
            temp[p++] = nums[i++];
        }

        while (j <= r) {
            temp[p++] = nums[j++];
        }

        p = 0;
        for(int k = l; k <= r; k++) {
            nums[k] = temp[p++];
        }

        return leftSum + sum + rightSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(getMinSum(nums));
    }
}
