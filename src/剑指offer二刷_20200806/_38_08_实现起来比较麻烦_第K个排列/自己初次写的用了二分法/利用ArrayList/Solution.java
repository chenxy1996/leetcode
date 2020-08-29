package 剑指offer二刷_20200806._38_08_实现起来比较麻烦_第K个排列.自己初次写的用了二分法.利用ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 60 题
 */
public class Solution {
    public static String getPermutation(int n, int k) {
        int prod= 1;
        List<Integer> bag = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            bag.add(i);
            prod *= i;
        }
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            int slotSize = prod / n;
            int l = 1;
            int r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (k <= slotSize * m) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            k -= slotSize * (l - 1);
            ans.append(bag.remove(l - 1));
            prod = slotSize;
            n--;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n, k));
    }
}
