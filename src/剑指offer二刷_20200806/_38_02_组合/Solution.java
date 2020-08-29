package 剑指offer二刷_20200806._38_02_组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(new ArrayList<>(), n, k, 1);
        return ans;
    }

    private void combine(List<Integer> bag, int n, int k, int i) {
        int size = bag.size();
        if (size == k) {
            ans.add(new ArrayList<>(bag));
            return;
        }
        for(int j = i; j <= n && size + n - j + 1 >= k; j++) {
            bag.add(j);
            combine(bag, n, k, j + 1);
            bag.remove(bag.size() - 1);
        }
    }
}
