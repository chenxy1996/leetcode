package 剑指offer二刷_20200806._40_01_排序衍生_最小的K个数.堆排序;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    class Heap {
        private int[] arr;
        private Comparator<Integer> comp;
        private int len;

        public Heap(int[] arr, Comparator<Integer> comp) {
            this.arr = arr;
            this.comp = comp;
            this.len = arr.length;
            construct();
        }

        public int peek() {
            return arr[0];
        }

        public void alter(int num) {
            arr[0] = num;
            modifyFromTop(0);
        }

        private void construct() {
            for(int i = len / 2 - 1; i >= 0; i--) {
                modifyFromTop(i);
            }
        }

        private void modifyFromTop(int p) {
            int pivot = arr[p];
            for(int k = 2 * p + 1; k < len; k = 2 * k + 1) {
                if (k + 1 < len && comp.compare(arr[k], arr[k + 1]) > 0) {
                    k = k + 1;
                }
                if (comp.compare(pivot, arr[k]) > 0) {
                    arr[p] = arr[k];
                    p = k;
                } else {
                    break;
                }
            }
            arr[p] = pivot;
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = Arrays.copyOf(arr, k);
        Heap heap = new Heap(ans, (a, b) -> b - a);
        for(int i = k; i < arr.length; i++) {
            if (arr[i] < heap.peek()) {
                heap.alter(arr[i]);
            }
        }
        return ans;
    }
}
