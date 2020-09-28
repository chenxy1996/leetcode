package NetEase20200912._3_;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s.split(" ").length);
    }
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] arr = new int[n - 1];
//        for(int i = 0; i < n - 1; i++) {
//            arr[i] = scanner.nextInt();
//        }
//
//        boolean[][] map = new boolean[n][n];
//        for(int i = 0; i < n - 1; i++) {
//            map[i + 1][arr[i]] = true;
//            map[arr[i]][i + 1] = true;
//        }
//
//        Map<Integer, Integer> rec = new HashMap<>();
//        traverse(map, 0, k, rec);
//        System.out.println(ans);
//    }
//
//    private static int ans = 1;
//
//    private static void traverse(boolean[][] map, int i, int k, Map<Integer, Integer> record) {
//        if (k == 0) {
//            ans = Math.max(ans, record.size());
//            return;
//        }
//
//        record.put(i, record.getOrDefault(i, 0) + 1);
//        for(int j = 0; j < map[0].length; j++) {
//            if (j != i && map[i][j]) {
//                traverse(map, j, k - 1, record);
//            }
//        }
//        record.put(i, record.get(i));
//        if (record.get(i) == 0) {
//            record.remove(i);
//        }
//    }
}
