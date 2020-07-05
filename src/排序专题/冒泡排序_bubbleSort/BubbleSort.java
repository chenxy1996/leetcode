<<<<<<< HEAD
package 排序专题.冒泡排序_bubbleSort;

import 排序专题.SortTest;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // 改进版
    public static void sortEffectively(int[] nums) {
        boolean go = true;
        for (int i = 0; i < nums.length && go; i++) {
            go = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    go = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Boolean res = SortTest.test(BubbleSort::sortEffectively);
        System.out.println(res);
    }
}
=======
package 排序专题.冒泡排序_bubbleSort;

import 排序专题.SortTest;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // 改进版
    public static void sortEffectively(int[] nums) {
        boolean go = true;
        for (int i = 0; i < nums.length && go; i++) {
            go = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    go = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Boolean res = SortTest.test(BubbleSort::sortEffectively);
        System.out.println(res);
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
