package 难点_二分法._0852_山脉数组的峰顶索引;

public class Solution {
    public int peekIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (arr[m + 1] > arr[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
