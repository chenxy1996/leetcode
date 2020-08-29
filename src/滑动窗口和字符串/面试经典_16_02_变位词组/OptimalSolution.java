package 滑动窗口和字符串.面试经典_16_02_变位词组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimalSolution {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 准备好一个离散质数数组
        int[] table = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        HashMap<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long product = 1;
            for (char c : str.toCharArray()) {
                product *= table[c - 'a'];
            }
            map.computeIfAbsent(product, a -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
