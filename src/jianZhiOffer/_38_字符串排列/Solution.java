<<<<<<< HEAD
package jianZhiOffer._38_字符串排列;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        List<String> res = new ArrayList<>();
        List<Character> remain = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            remain.add(s.charAt(i));
        }

        dfs(remain, "", res);
        return res.toArray(String[]::new);
    }

    private void dfs(List<Character> remain, String s, List<String> res) {
        if (remain.size() == 0) {
            res.add(s);
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < remain.size(); i++) {
            char c = remain.get(i);
            if (!set.contains(c)) {
                set.add(c);
                remain.remove(i);
                dfs(remain, s + c, res);
                remain.add(i, c);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abca";
        String[] res = solution.permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
=======
package jianZhiOffer._38_字符串排列;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        List<String> res = new ArrayList<>();
        List<Character> remain = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            remain.add(s.charAt(i));
        }

        dfs(remain, "", res);
        return res.toArray(String[]::new);
    }

    private void dfs(List<Character> remain, String s, List<String> res) {
        if (remain.size() == 0) {
            res.add(s);
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < remain.size(); i++) {
            char c = remain.get(i);
            if (!set.contains(c)) {
                set.add(c);
                remain.remove(i);
                dfs(remain, s + c, res);
                remain.add(i, c);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abca";
        String[] res = solution.permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
