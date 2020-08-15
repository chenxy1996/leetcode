package 剑指offer._0_剑指offer二刷_20200806._11_01_旋转数组的最小数字;

public class Solution {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int m = (r - l) / 2 + l;
            int val = numbers[m];
            if (val > numbers[r]) {
                l = m + 1;
            } else if (val < numbers[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return numbers[l];
    }
}
