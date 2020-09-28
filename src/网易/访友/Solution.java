package 网易.访友;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n / 5 + (n % 5 == 0 ? 0 : 1));
    }
}
