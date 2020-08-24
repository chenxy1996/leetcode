package 剑指offer二刷_20200806._38_07_比特位计数;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        int cnt = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            cnt++;
            for(int i = 0; i < size; i++) {
                int front = deque.removeFirst();
                int mask = 1;
                int t = front;
                while (mask <= num && (t & 1) != 1) {
                    int val = mask | front;
                    if (val <= num) {
                        ans[val] = cnt;
                        deque.addLast(val);
                        mask <<= 1;
                        t = t >>> 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = countBits(n);
        System.out.println(Arrays.toString(ans));
    }
}
