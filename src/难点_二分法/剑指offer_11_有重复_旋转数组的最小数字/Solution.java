package 难点_二分法.剑指offer_11_有重复_旋转数组的最小数字;

// [2,2,2,0,1]
// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。

/**
 * 有重复数字
 */
public class Solution {
    public static int minArray(int[] numbers) {
        int s = 0;
        int e = numbers.length - 1;
        while (s <= e) {
            int m = (e - s) / 2 + s;
            int val = numbers[m];
            if (val > numbers[e]) {
                s = m + 1;
            } else if (val < numbers[e]){
                e = m;
            } else {
                e--;
            }
        }
        return numbers[s];
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3};
        System.out.println(minArray(arr));
    }
}
