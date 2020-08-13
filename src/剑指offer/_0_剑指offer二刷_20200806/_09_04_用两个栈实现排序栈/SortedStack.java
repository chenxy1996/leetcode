package 剑指offer._0_剑指offer二刷_20200806._09_04_用两个栈实现排序栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortedStack {
    Deque<Integer> main = new ArrayDeque<>();
    Deque<Integer> help = new ArrayDeque<>();

    public SortedStack() {
    }

    public void push(int val) {
        if (help.isEmpty() || val > help.peekLast()) {
            insertToMain(val);
        } else {
            insertToHelp(val);
        }
    }

    private void insertToMain(int val) {
        while (!main.isEmpty() && val > main.peekLast()) {
            help.addLast(main.removeLast());
        }
        main.addLast(val);
    }

    private void insertToHelp(int val) {
        while (!help.isEmpty() && val < help.peekLast()) {
            main.addLast(help.removeLast());
        }
        help.addLast(val);
    }

    public void pop() {
        int res = peek();
        if (res != -1) {
            main.removeLast();
        }
    }

    public int peek() {
        while (!help.isEmpty()) {
            main.addLast(help.removeLast());
        }
        return main.isEmpty() ? -1 : main.peekLast();
    }

    public boolean isEmpty() {
        return main.isEmpty() && help.isEmpty();
    }
}
