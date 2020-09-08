package 题目._0179_快速排序_最大的数.更加简洁的解法;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static String largestNumber(int[] nums) {
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            arr.add(String.valueOf(nums[i]));
        }
        Comparator<String> comp = (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        };
        String ans = arr.stream().sorted(comp).collect(Collectors.joining());
        return ans.charAt(0) == '0' ? "0" : ans;
    }
}
