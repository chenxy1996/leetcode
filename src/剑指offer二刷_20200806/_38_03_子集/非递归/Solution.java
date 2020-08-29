package 剑指offer二刷_20200806._38_03_子集.非递归;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : nums) {
            int size = ans.size();
            for(int i = 0; i < size; i++) {
                List<Integer> front = new ArrayList<>(ans.get(i));
                front.add(num);
                ans.add(front);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}
