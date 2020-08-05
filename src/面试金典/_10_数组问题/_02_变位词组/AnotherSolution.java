package 面试金典._10_数组问题._02_变位词组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnotherSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long sum = 0;
            long pro = 1;
            for (char c : str.toCharArray()) {
                sum += c;
                pro *= c;
            }
            long key = (pro << 32) ^ sum;
            map.computeIfAbsent(key, a -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"her", "old"};
        System.out.println(new Solution().groupAnagrams(s));
    }
}
