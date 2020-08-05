package jianZhiOffer._11_旋转数组的最小数字20200720;

public class Solution {
    // 利用二分法
    public int minArray(int[] numbers) {// TODO
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = numbers[m];
            if (val > numbers[r]) {
                l = m + 1;
            } else if (val < numbers[r]){
                r = m;
            } else {
                // 下面这个非常关键
                r--;
            }
        }

        return numbers[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,1,1,1,1,2,1,1,1};
        System.out.println(solution.minArray(nums));
    }
}
