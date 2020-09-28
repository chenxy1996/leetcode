package NetEase20200912._2_;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Map<String, Integer> map = new HashMap<>();
        System.out.println(dfs(s, map));
    }

    private static int dfs(String s, Map<String, Integer> map) {
        if (s.length() == 0) {
            return 0;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int[] mapABC = new int[3];
        int[] mapXYZ = new int[3];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                mapABC[0]++;
            }
            if (c == 'b') {
                mapABC[1]++;
            }
            if (c == 'c') {
                mapABC[2]++;
            }
            if (c == 'x') {
                mapXYZ[0]++;
            }
            if (c == 'y') {
                mapXYZ[1]++;
            }
            if (c == 'z') {
                mapXYZ[2]++;
            }
        }
        int i = 0;
        for (; i < 3; i++) {
            if ((mapABC[i] & 1) == 1) {
                break;
            }
        }
        if (i < 3) {
            char c = (char) ('a' + i);
            int ans = 0;
            for(int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == c) {
                    int left = dfs(s.substring(0, k), map);
                    int right = dfs(s.substring(k + 1), map);
                    ans = Math.max(ans, Math.max(left, right));
                }
            }
            map.put(s, ans);
            return ans;
        }
        i = 0;
        for (; i < 3; i++) {
            if ((mapXYZ[i] & 1) == 1) {
                break;
            }
        }
        if (i < 3) {
            char c = (char) ('x' + i);
            int ans = 0;
            for(int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == c) {
                    int left = dfs(s.substring(0, k), map);
                    int right = dfs(s.substring(k + 1), map);
                    ans = Math.max(ans, Math.max(left, right));
                }
            }
            map.put(s, ans);
            return ans;
        }
        return s.length();
    }
}
