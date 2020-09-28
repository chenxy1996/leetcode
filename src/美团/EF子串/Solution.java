package 美团.EF子串;

import java.util.Scanner;

public class Solution {
    private static void maxDelta(String s) {
        char[] cs = s.toCharArray();
        int d = 0;
        int ans = 0;
        for(int i = 0; i < cs.length; i++) {
            if (cs[i] == 'E') {
                if (d >= 0) {
                    d++;
                } else {
                    d = 1;
                }
            } else {
                if (d >= 0) {
                    d--;
                } else {
                    d = -1;
                }
            }
            ans = Math.max(d, ans);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        maxDelta(s);
    }
}
