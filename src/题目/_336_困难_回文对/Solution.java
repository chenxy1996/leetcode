package dp._336_困难_回文对;

import java.util.*;

public class Solution {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> have = new HashMap<>();
        Map<String, Integer> headNeed = new HashMap<>();
        Map<String, Integer> tailNeed = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int p = 0; p < words.length; p++) {
            String s = words[p];
            for(int i = 0; i < s.length(); i++) {

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcd";
    }
}
