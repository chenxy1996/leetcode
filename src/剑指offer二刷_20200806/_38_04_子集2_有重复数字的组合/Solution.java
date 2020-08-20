package 剑指offer二刷_20200806._38_04_子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90
 */
public class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int lastAdded = 0;
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int size = ans.size();
            if (i > 0 && val == nums[i - 1]) {
                for(int j = size - 1; j > size - lastAdded - 1; j--) {
                    List<Integer> bag = new ArrayList<>(ans.get(j));
                    bag.add(val);
                    ans.add(bag);
                }
            } else {
                for(int j = 0; j < size; j++) {
                    List<Integer> bag = new ArrayList<>(ans.get(j));
                    bag.add(val);
                    ans.add(bag);
                }
                lastAdded = size;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }
}
