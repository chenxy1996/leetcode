package 题目._全排列_;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> bag = new ArrayList<>();
        for(int e : nums) {
            bag.add(e);
        }
        dfs(0, bag);
        return ans;
    }

    private void dfs(int p, List<Integer> bag) {
        if (p == bag.size()) {
            ans.add(new ArrayList<>(bag));
            return;
        }

        for(int i = p; i < bag.size(); i++) {
            swap(bag, p, i);
            dfs(p + 1, bag);
            swap(bag, p, i);
        }
    }

    private void swap(List<Integer> bag, int i, int j) {
        int temp = bag.get(i);
        bag.set(i, bag.get(j));
        bag.set(j, temp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }
}
