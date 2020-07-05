package jianZhiOffer._9_CQueue;

public class CQueue {
    private static final int INITIAL_SIZE = 2;
    private int[] data = new int[INITIAL_SIZE];
    private int size = 0;
    private int start = 0;

    public CQueue() {}

    public void appendTail(int value) {
        ensureCapacity();
        data[start + size] = value;
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        int ret = data[start];
        start++;
        size--;
        return ret;
    }

    private void ensureCapacity() {
        if (start + size == data.length) {
            int[] copy = new int[Math.max(size << 1, INITIAL_SIZE)];
            System.arraycopy(data, start, copy, 0, size);
            start = 0;
            data = copy;
        }
    }

    public static void main(String[] args) {

    }
}
