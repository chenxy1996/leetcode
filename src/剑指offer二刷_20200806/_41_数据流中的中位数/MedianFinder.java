package 剑指offer二刷_20200806._41_数据流中的中位数;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> a - b);
    private int size = 0;

    /** initialize your data structure here. */
    public MedianFinder() {
    }

    public void addNum(int num) {
        if (min.size() == max.size()) {
            max.add(num);
            min.add(max.poll());
        } else {
            min.add(num);
            max.add(min.poll());
        }
        size++;
    }

    public double findMedian() {
        double ans;
        if ((size & 1) == 1) {
            ans = min.peek();
        } else {
            ans = (min.peek() + max.peek()) / 2.0;
        }
        return ans;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
    }
}
