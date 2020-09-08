package 题目._0179_快速排序_最大的数;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static String largestNumber(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        Comparator<String> comp = (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            for(int i = 0; i < s1.length(); i++) {
                int p1 = s1.charAt(i) - '0';
                int p2 = s2.charAt(i) - '0';
                if (p1 > p2) {
                    return -1;
                } else if (p1 < p2) {
                    return 1;
                }
            }
            return 0;
        };
        String ans = arr.stream().map(String::valueOf).
                sorted(comp).
                collect(Collectors.joining());
        int i = 0;
        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }
        return ans.substring(i);
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0};
        System.out.println(largestNumber(arr));
    }
}
