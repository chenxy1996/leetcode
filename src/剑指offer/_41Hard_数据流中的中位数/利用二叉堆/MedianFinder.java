package 剑指offer._41Hard_数据流中的中位数.利用二叉堆;

import java.util.Arrays;
import java.util.Comparator;

public class MedianFinder {
    private static class BinaryHeap {
        private int[] heap;
        private Comparator<Integer> comparator;

        public BinaryHeap(int[] nums, Comparator<Integer> comparator) {
                this.heap = nums;
                this.comparator = comparator;
                construct();
            }

        public BinaryHeap(Comparator<Integer> comparator) {
                this.comparator = comparator;
                this.heap = new int[0];
            }

        public int size() {
            return heap.length;
        }

        private void construct() {
            for (int i = heap.length / 2 - 1; i >= 0; i--) {
                permeateFromTop(i);
            }
        }

        // permeateFromTop
        private void permeateFromTop(int p) {
            int temp = heap[p];
            for (int k = 2 * p + 1; k < heap.length; k = 2 * k + 1) {
                if (k + 1 < heap.length && comparator.compare(heap[k], heap[k + 1]) > 0) {
                    k++;
                }
                if (comparator.compare(temp, heap[k]) > 0) {
                    heap[p] = heap[k];
                    p = k;
                } else {
                    break;
                }
            }
            heap[p] = temp;
        }

        // permeateFromDown
        private void permeateFromDown() {
            int i = heap.length - 1;
            int temp = heap[i];
            for (int k = (i - 1) / 2; i > 0; k = (k - 1) / 2) {
                if (comparator.compare(temp, heap[k]) > 0) {
                    break;
                } else {
                    heap[i] = heap[k];
                    i = k;
                }
            }
            heap[i] = temp;
        }

        private void ensureHasElement() throws Exception {
            if (heap.length == 0) {
                throw new Exception("no elements in heap.");
            }
        }

        public int[] getHeap() {
            return Arrays.copyOf(heap, heap.length);
        }

        public int peekTop() throws Exception {
            ensureHasElement();
            return heap[0];
        }

        public int pollTop() throws Exception {
            ensureHasElement();
            int res = heap[0];
            heap[0] = heap[heap.length - 1];
            deflate();
            if (heap.length > 0) {
                permeateFromTop(0);
            }
            return res;
        }

        public void add(int num) {
            inflate();
            heap[heap.length - 1] = num;
            permeateFromDown();
        }

        private void deflate() {
            heap = Arrays.copyOf(heap, heap.length - 1);
        }

        private void inflate() {
            heap = Arrays.copyOf(heap, heap.length + 1);
        }
    }

    private BinaryHeap minHeap;
    private BinaryHeap maxHeap;
    private int size = 0;

    public MedianFinder() {
        minHeap = new BinaryHeap(Comparator.reverseOrder());
        maxHeap = new BinaryHeap(Comparator.naturalOrder());
    }

    public void addNum(int num) throws Exception {
        if (size == 0) {
            minHeap.add(num);
        } else if (size == 1) {
            int temp = minHeap.pollTop();
            minHeap.add(Math.min(temp, num));
            maxHeap.add(Math.max(temp, num));
        } else {
            if (maxHeap.peekTop() > num) {
                minHeap.add(num);
                if (minHeap.size() - maxHeap.size() > 1) {
                    int temp = minHeap.pollTop();
                    maxHeap.add(temp);
                }
            } else {
                maxHeap.add(num);
                if (maxHeap.size() - minHeap.size() > 1) {
                    int temp = maxHeap.pollTop();
                    minHeap.add(temp);
                }
            }
        }
        size++;
    }

    public double findMedian() throws Exception {
        if ((size & 1) == 0) {
            return (maxHeap.peekTop() + minHeap.peekTop()) / 2.0;
        } else {
            return minHeap.size() > maxHeap.size() ? minHeap.peekTop() : maxHeap.peekTop();
        }
    }

    public static void main(String[] args) throws Exception {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(4);
        System.out.println(mf.findMedian());
    }
}
