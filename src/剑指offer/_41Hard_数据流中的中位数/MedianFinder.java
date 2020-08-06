package 剑指offer._41Hard_数据流中的中位数;

import java.util.Arrays;

public class MedianFinder {
    private int[] arr;

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (arr == null) {
            arr = new int[] {num};
        } else{
            int pos = findPos(num);
            arr = Arrays.copyOf(arr, arr.length + 1);
            for (int i = arr.length - 1; i > pos; i--) {
                arr[i] = arr[i - 1];
            }
            arr[pos] = num;
        }
    }

    public double findMedian() {
        int r = arr.length >> 1;
        if ((arr.length & 1) == 1) {
            return arr[r];
        } else {
            return (arr[r] + arr[r - 1]) / 2.0;
        }
    }

    private int findPos(int num) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = arr[(int) m];
            if (valM <= num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(7);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
