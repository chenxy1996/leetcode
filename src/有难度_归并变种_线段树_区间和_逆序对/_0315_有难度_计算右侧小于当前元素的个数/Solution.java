package 有难度_归并变种_线段树_区间和_逆序对._0315_有难度_计算右侧小于当前元素的个数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        int[] index = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        ans = new int[nums.length];
        merge(index, 0, nums.length - 1, nums);
        List<Integer> res = new ArrayList<>();
        for(int e : ans) {
            res.add(e);
        }
        return res;
    }

    private void merge(int[] index, int l, int r, int[] nums) {
        if (l >= r) {
            return;
        }

        int m = (r - l) / 2 + l;
        merge(index, l, m, nums);
        merge(index, m + 1, r, nums);

        int i = l, j = m + 1, p = 0;
        int[] temp = new int[r - l + 1];

        while (i <= m && j <= r) {
            int val1 = nums[index[i]];
            int val2 = nums[index[j]];

            if (val1 > val2) {
                temp[p++] = index[j++];
            } else {
                ans[index[i]] += j - m - 1;
                temp[p++] = index[i++];
            }
        }
        while (i <= m) {
            ans[index[i]] += r - m;
            temp[p++] = index[i++];
        }
        while (j <= r) {
            temp[p++] = index[j++];
        }
        p = 0;
        while (l <= r) {
            index[l++] = temp[p++];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 2, 6, 1};
        System.out.println(solution.countSmaller(nums));
    }
}
