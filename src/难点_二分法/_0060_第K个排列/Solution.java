package 难点_二分法._0060_第K个排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        int prod = 1;
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
}
