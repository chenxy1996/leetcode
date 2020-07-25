package 面试金典._03_栈问题._05_我觉得挺难的_栈排序;

import java.util.Stack;

public class RefinedSortedStack {
    private Stack<Integer> main = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void push(int val) {
        if (main.isEmpty()) {
            main.push(val);
        } else {
            if (help.size() == 0) {
                insertToMain(val);
            } else {
                int mainTop = main.peek();
                if (val >= mainTop) {
                    insertToMain(val);
                } else {
                    insertToHelp(val);
                }
            }
        }
    }

    private void insertToMain(int val) {
        while (!main.isEmpty() && main.peek() < val) {
            help.push(main.pop());
        }
        main.push(val);
    }

    private void insertToHelp(int val) {
        while (!help.isEmpty() && help.peek() > val) {
            main.push(help.pop());
        }
        help.push(val);
    }

    public void pop() {
        while (!help.isEmpty()) {
            main.push(help.pop());
        }
        if (!main.isEmpty()) {
            main.pop();
        }
    }

    public int peek() {
        while (!help.isEmpty()) {
            main.push(help.pop());
        }
        if (!main.isEmpty()) {
            return main.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return main.isEmpty() && help.isEmpty();
    }

    public static void main(String[] args) {
        RefinedSortedStack st = new RefinedSortedStack();
        st.push(1);
        st.push(2);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
    }
}
