package 题目._1574_删除最短的子数组使剩余数组有序;

public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int len =arr.length;
        int l = 0;
        int r = len - 1;

        while (l + 1 < len) {
            if (arr[l] <= arr[l + 1]) {
                l++;
            } else {
                break;
            }
        }
        if (l == len - 1) {
            return 0;
        }

        while (r - 1 >= 0) {
            if (arr[r] >= arr[r - 1]) {
                r--;
            } else {
                break;
            }
        }

        // 去掉前面的一段或者后面的一段
        int ans = Math.min(len - 1 - l, r);

        // 尝试去掉中间的段
        for(int i = 0, j = r; i <= l && j < len; i++) {
            while (j < len && arr[i] > arr[j]) {
                j++;
            }
            if (j < len) {
                ans = Math.min(j - i - 1, ans);
            }
        }

        return ans;
    }
}
