package 网易.买票问题;

import java.util.Scanner;

public class Solution {
    public static String helper(int seconds){
        int hours = seconds / 3600 + 8;
        String ap = hours > 12 ? "PM" : "AM";
        if (hours > 12){
            hours -= 12;
        }
        String h = hours > 9 ? hours + "" : "0" + hours ;
        seconds = seconds % 3600;
        int minutes = seconds / 60;
        String m = minutes > 9 ? minutes + "" : "0" + minutes ;
        seconds = seconds % 60;
        int second = seconds % 60;
        String s = second > 9 ? second + "" : "0" + second ;
        return h + ":" + m + ":" + s + " " + ap;
    }

    public static int minTime(int n, int[] a, int[] b) {
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.min(a[0]+a[1], b[0]);
        for (int j = 2; j < n; j++) {
            dp[j] = Math.min(dp[j - 1] + a[j], dp[j - 2] + b[j - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

    }
}
