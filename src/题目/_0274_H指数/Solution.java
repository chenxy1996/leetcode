package 题目._0274_H指数;

import java.util.Arrays;

public class Solution {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = citations.length; i >= 0; i--) {
            int p = find(citations, i);
            if (i <= citations.length - p) {
                return i;
            }
        }
        return 0;
    }

    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] citations = {7,7,7,7,7,7,7};
        System.out.println(hIndex(citations));
    }
}
