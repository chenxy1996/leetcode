package 排序专题.归并排序_mergeSort;

import 排序专题.SortTest;
import 排序专题.冒泡排序_bubbleSort.BubbleSort;

import java.util.Arrays;

public class MergeSort {
    // 递归方法
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        // avoid overflow
        int mid = start + (end - start) / 2;

        // 递归分治
        sort(arr, start, mid);
        sort(arr, mid + 1, end);

        // 此时分开的两部分是排序好的
        // 现在就是合并这已经排序好的两部分
        // 采用原地算法
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                // 将 arr[j] 插入到 arr[i] 位置
                int temp = arr[j];
                for (int k = j - 1; k >= i; k--) {
                    arr[k + 1] = arr[k];
                }
                arr[i] = temp;
                j++;
                mid++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Boolean res = SortTest.test(MergeSort::sort);
        System.out.println(res);
    }
}
