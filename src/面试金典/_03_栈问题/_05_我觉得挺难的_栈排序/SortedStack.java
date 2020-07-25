package 面试金典._03_栈问题._05_我觉得挺难的_栈排序;

// 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
// 最多只能使用一个其他的临时栈存放数据，但不得将元素
// 复制到别的数据结构（如数组）中。该栈支持如下操作：
// push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

import 排序专题.SortTest;

import java.util.Stack;

/**
 * 这道题初见，想使用一个最小堆，但是题目禁止使用。
 * 这道题目和之前那个 MinStack 类似
 * 初见没有想起来，我真是个 five ....
 */

// TODO 没想出
public class SortedStack {
    private Stack<Integer> main = new Stack<>();
    private Stack<Integer> temp = new Stack<>();

    public SortedStack() {}

    /**
     * 该测试案例中 push 的使用很多次，所以为了降低时间消耗可以采用惰性策略见 RefinedSortedStack
     */
    public void push(int val) {
        if (main.isEmpty()) {
            main.push(val);
        } else {
            int top;
            while (!main.isEmpty() && (top = main.peek()) < val) {
                temp.push(main.pop());
            }
            main.push(val);
            while (!temp.isEmpty()) {
                main.push(temp.pop());
            }
        }
    }

    public void pop() {
        if (!main.isEmpty()) {
            main.pop();
        }
    }

    public int peek() {
        if (main.isEmpty()) {
            return -1;
        } else {
            return main.peek();
        }
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack st = new SortedStack();
        st.push(1);
        st.push(2);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
    }
}
