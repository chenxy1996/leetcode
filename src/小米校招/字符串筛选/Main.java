package 小米校招.字符串筛选;

import java.util.Scanner;

/**
 * 给定一个字符串, 需要去除所有之前曾经出现过的字符，只保留第一次出现的字符
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(filter(s));
        }
    }

    private static String filter(String s) {
        boolean[] map = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map[c]) {
                map[c] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
