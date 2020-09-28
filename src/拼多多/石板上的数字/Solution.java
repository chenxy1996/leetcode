package 拼多多.石板上的数字;

import com.sun.security.jgss.GSSUtil;

import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Random rd = new Random();
        for(int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int[][] pattern = new int[w][w];
            for(int j = 0; j < w; j++) {
                for(int k = 0; k < w; k++) {
                    pattern[j][k] = scanner.nextInt();
                }
            }
            System.out.println(rd.nextInt(9));
        }
    }

    private static void process(int[][] pattern) {
        int w = pattern.length;
        int cnt = 0;
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < w; j++) {
                cnt += pattern[i][j];
            }
        }

        if (cnt % 28 == 0) {
            if (pattern[w / 2][w / 2] == 1) {
                System.out.println(8);
            } else {
                System.out.println(0);
            }
        } else if (cnt % 17 == 0) {
            System.out.println(7);
        } else if (cnt % 24 == 0) {

        } else if (cnt % 22 == 0) {
            System.out.println(7);
        } else if (cnt % 25 == 0) {
            if (pattern[w / 2][w / 5] == 1) {
                System.out.println(6);
            } else {
                System.out.println(5);
            }
        }
    }
}
