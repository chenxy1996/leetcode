package 题目._0030_困难_串联所有单词的子串;

// 给定一个字符串 s 和一些长度相同的单词 words。找出
// s 中恰好 可 以由 words 中所有单词串联形成的子串
// 的起始位置。注意子串要与 words 中的单词完全匹配，
// 中间不能有其他字符，但不需要考虑 words 中单词串
// 联的顺序。

// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]

// 输出：[0,9]

import java.util.*;

// 解释：
// 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
// 输出的顺序不重要, [9,0] 也是有效答案。

/**
 * 题目恶心，但是并不是很难，太繁琐
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return res;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int len = s.length();
        int cell = words[0].length();
        int wordsLen = words.length;

        for (int m = 0; m < cell; m++) {
            int storeSize = 0;
            HashMap<String, List<Integer>> store = new HashMap<>();
            for (int p = m; p < len; p += cell) {
                String ss = s.substring(p, Math.min(len, p + cell));
                if (map.containsKey(ss)) {
                    if (!store.containsKey(ss)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(p);
                        store.put(ss, list);
                    } else if (store.get(ss).size() < map.get(ss)) {
                        store.get(ss).add(p);
                    } else {
                        int min = store.get(ss).get(0);
                        storeSize = 0;
                        // 删除 store 中所有小于等于 min 的字符存储
                        for (List<Integer> value : store.values()) {
                            storeSize += value.size();
                            Iterator<Integer> iterator = value.iterator();
                            while (iterator.hasNext()) {
                                int val = iterator.next();
                                if (val <= min) {
                                    iterator.remove();
                                    storeSize--;
                                }
                            }
                        }
                        store.get(ss).add(p);
                    }
                    storeSize++;
                } else {
                    store.clear();
                    storeSize = 0;
                }

                if (storeSize == wordsLen) {
                    res.add(p - (storeSize - 1) * cell);
                    storeSize = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String s = "abaababbaba";
//        String[] words = {"fooo","barr","wing","ding","wing"};
        String[] words = {"ba","ab","ab"};
        System.out.println(solution.findSubstring(s, words));
    }
}
