package 网易.素数的个数;

import java.util.Scanner;

public class Solution {
    public static int split(int num) {
        return num >= 1 ? num / 2 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int n : arr) {
            ans += split(n);
        }
        System.out.println(ans);
    }
}
