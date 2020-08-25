package 滑动窗口和字符串._438_字符串太长了不能用_找到字符串中所有字母异位词.利用离散数组生成哈希值;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        // 准备好一个离散质数数组
        int[] table = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        List<Integer> ans = new ArrayList<>();

//        long module = 1L << 31;
        long refHash = 1;
        long hash = 1;

        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();

        for (char c : ps) {
            refHash = refHash * table[c - 'a'];
        }

        for (int i = 0; i < ss.length; i++) {
            char c = ss[i];
            if (i >= ps.length) {
                char pc = ss[i - ps.length];
                hash = hash / table[pc - 'a'];
            }
            hash = hash * table[c - 'a'];
            if (i >= ps.length - 1 && hash == refHash) {
                ans.add(i - ps.length + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String p = "zzzzzzzzz";
        System.out.println(findAnagrams(s, p));
//        System.out.println(101 * 101);
//        System.out.println(101 * 101 * 101);
//        System.out.println(101 * 101 * 101 * 101);
    }
}
