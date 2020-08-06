package 剑指offer._50_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
