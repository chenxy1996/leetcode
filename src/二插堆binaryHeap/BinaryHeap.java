package 二插堆binaryHeap;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;

public class BinaryHeap {
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

    public static void main(String[] args) throws Exception {
    }
}
