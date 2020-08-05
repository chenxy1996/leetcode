package 难点_二分法.面试金典_10_03_有重复_困难_搜索旋转数组;

public class Solution {
    public static int search(int[] arr, int target) {
        // 找到旋转数组的最小值
        int l = 0;
        int len = arr.length;
        int r = len - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            int val = arr[m];
            if (val > arr[r]) {
                l = m + 1;
            } else if (val < arr[r]) {
                r = m;
            } else {
                r--;
            }
        }
        // 一般来说 l 就是最小值点, 但是会有意外的情况：1,1,1,1,1,2,1,1,1
        // 这种情况 l 最后为 0，但是不能用
        r = len - 1;
        while (l == 0 && r > 0 && arr[r] == arr[0]) {
            r--;
        }

        int ans;
        if (l > 0) {
            ans = search(arr, 0, l - 1, target);
            if (ans != -1) {
                return ans;
            }
        }
        ans = search(arr, l, r, target);
        return ans;
    }

    private static int search(int[] arr, int s, int e, int target) {
        int l = s;
        int r = e;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (arr[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l <= e && arr[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(search(nums, 1));
    }
}
