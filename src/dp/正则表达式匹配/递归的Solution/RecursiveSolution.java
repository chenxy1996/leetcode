package dp.正则表达式匹配.递归的Solution;

import java.util.HashMap;
import java.util.Map;

public class RecursiveSolution {
    public static Map<String, Boolean> map = new HashMap<>();

    // 无减枝版，会超时间
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0 ? true : false;
        }

        // 1. s.length() > 0 && p.length() > 0
        // 2. s.length() == 0 && p.length() > 0
        char pc = p.charAt(0);
        if (pc == '?') {
            return s.length() == 0 ? false : isMatch(s.substring(1), p.substring(1));
        } else if (pc == '*') {
            return isMatch(s, p.substring(1)) || // 不匹配
                    (s.length() > 0 && isMatch(s.substring(1), p.substring(1))) || // 匹配一个
                    (s.length() > 0 && isMatch(s.substring(1), p)); // 继续匹配
        } else {
            if (s.length() > 0) {
                char sc = s.charAt(0);
                return sc == pc && isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    // 减枝版
    public static boolean isMatch1(String s, String p) {
        Boolean res;
        if ((res = map.get(s + "|" + p)) != null) {
            return res;
        }

        if (p.length() == 0) {
            res = s.length() == 0 ? true : false;
        } else {
            // 1. s.length() > 0 && p.length() > 0
            // 2. s.length() == 0 && p.length() > 0
            char pc = p.charAt(0);
            if (pc == '?') {
                res = s.length() == 0 ? false : isMatch1(s.substring(1), p.substring(1));
            } else if (pc == '*') {
                res = isMatch1(s, p.substring(1)) || // 不匹配
                        (s.length() > 0 && isMatch1(s.substring(1), p.substring(1))) || // 匹配一个
                        (s.length() > 0 && isMatch1(s.substring(1), p)); // 继续匹配
            } else {
                if (s.length() > 0) {
                    char sc = s.charAt(0);
                    res = sc == pc && isMatch1(s.substring(1), p.substring(1));
                } else {
                    res = false;
                }
            }
        }

        map.put(s + "|" + p, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String p = "*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*";

        System.out.println(isMatch1(s, p));
    }
}
