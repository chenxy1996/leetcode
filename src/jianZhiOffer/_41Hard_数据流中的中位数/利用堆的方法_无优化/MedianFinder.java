package jianZhiOffer._41Hard_数据流中的中位数.利用堆的方法_无优化;

import java.util.Arrays;
import java.util.Comparator;

// 这次解答题目中用的分类考虑的情况比较多
// 看起来比较复杂
public class MedianFinder {
    private int[] min = new int[0]; // min[0] 为最大的数
    private int[] max = new int[0]; // max[0] 为最小的数
    private int count = 0; // min 和 max 中的总数

    public MedianFinder() {
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            return (max[0] + min[0]) / 2.0;
        } else {
            return min[0];
        }
    }

    public void addNum(int num) {
        count++;
        if (min.length == max.length) {
            // 如果 min 和 max 的长度相等，扩张 min 的长度 + 1
            min = Arrays.copyOf(min, min.length + 1);
            if (min.length == 1) {
                min[0] = num;
                return;
            }
            if (num <= min[0]) {
                // num 小于等于 min 中最大值 min[0]
                min[min.length - 1] = num;
            } else {
                // num 大于 min 中最大值 min[0]
                if (num > max[0]) {
                    // 此时如果 num 比 max 中的最小值 max[0] 大,
                    // 直接把 max[0] 添加进 min 中, max[0] 一定是 min 中的最大值
                    min[min.length - 1] = min[0];
                    min[0] = max[0];
                    // 把 max[0] 替换为 num
                    max[0] = num;
                    // 直接调节 max 数组, 让 max[0] 是 max 中的最小值
                    constructHeap(max, (a, b) -> a - b);
                } else {
                    // 如果 num 比 max 中的最小值 max[0] 小
                    // 说明 min[0] < num <= max[0]
                    // 直接把 num 添加进 min 中, num 一定是 min 中的最大值
                    min[min.length - 1] = min[0];
                    min[0] = num;
                }
            }
        } else {
            // 此时 min 的长度比 max 的长度要大1，扩张 max 的长度 + 1
            max = Arrays.copyOf(max, max.length + 1);
            if (max.length == 1) {
                // 说明刚刚才给 max 分配空间比较 min[0] 和 num 大小，
                // 让 min[0] <= max[0]
                int temp = min[0];
                min[0] = Math.min(temp, num);
                max[0] = Math.max(temp, num);
                return;
            }
            if (num >= max[0]) {
                // num 大于等于 max 中的最小值 max[0]
                // 直接将 num 添加到扩张后的 max 的最后
                max[max.length - 1] = num;
            } else {
                // num 比 max 中的最小值 max[0] 小
                if (num >= min[0]) {
                    // num 大于等于 min 中的最大值 min[0]
                    // 此时 min[0] <= num < max[0]
                    // 将 max 中的 最小值 max[0] 替换为 num
                    max[max.length - 1] = max[0];
                    max[0] = num;
                } else {
                    // num 小于 min 中的最大值 min[0]
                    // min[0] 一定有 min[0] <= max[0]
                    // 将 max[0] 直接替换为 min[0]
                    max[max.length - 1] = max[0];
                    max[0] = min[0];
                    // 把 min[0] 替换为 num
                    min[0] = num;
                    // 调节 min, 是的 min[0] 为 min 中的最大值
                    constructHeap(min, (a, b) -> b - a);
                }
            }
        }
    }

    private static void adjust(int[] heap, int i, Comparator<Integer> comparator) {
        int temp = heap[i];
        int end = heap.length - 1;
        for (int k = 2 * i + 1; k <= end; k = 2 * k + 1) {
            if (k + 1 <= end && comparator.compare(heap[k], heap[k + 1]) > 0) {
                k += 1;
            }
            if (comparator.compare(temp, heap[k]) > 0) {
                heap[i] = heap[k];
                i = k;
            } else {
                break;
            }
        }
        heap[i] = temp;
    }

    private static void constructHeap(int[] heap, Comparator<Integer> comparator) {
        for (int i = heap.length - 1; i >= 0; i--) {
            adjust(heap, i, comparator);
        }
    }

    public static void main(String[] args) {
        int[] nums = {8, 0, 3, 5, 9, 2, 0, 4, 6};
        constructHeap(nums, (a, b) -> a - b);
        System.out.println(Arrays.toString(nums));
        nums[0] = 7;
        constructHeap(nums, (a, b) -> a - b);
        System.out.println(Arrays.toString(nums));
        nums[0] = -1;
        constructHeap(nums, (a, b) -> a - b);
        System.out.println(Arrays.toString(nums));
    }
}
