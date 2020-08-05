package 面试金典._10_数组问题._03_二分法_难_搜索旋转数组;

public class Solution {
    public static int search(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            if (arr[s] == target) {
                return s;
            }
            int m = s + (e - s) / 2;
            int val = arr[m];
            if (arr[s] <= target && val >= target && val >= arr[s]) {
                return binarySearch(arr, s, m, target);
            } else if (val <= target && arr[e] >= target && arr[s] != target) {
                return binarySearch(arr, m, e, target);
            } else {
                s++;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int s, int e, int target) {
        int r = e;
        while (s <= r) {
            int m = s + (r - s) / 2;
            if (arr[m] >= target) {
                r = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s <= e && arr[s] == target ? s : -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,5,5,1,2,3,4,5};
        int target = 5;
        System.out.println(search(arr, target));
    }
}
