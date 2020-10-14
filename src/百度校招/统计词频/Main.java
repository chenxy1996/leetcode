package 百度校招.统计词频;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        Map<String, String> records = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split("\\W+");
        for(String w : words) {
            String lw = w.toLowerCase();
            if (!records.containsKey(lw)) {
                records.put(lw, w);
            }
            map.put(lw, map.getOrDefault(lw, 0) + 1);
        }
        String word = null;
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                word = entry.getKey();
            } else if (entry.getValue() == count) {
                if (entry.getKey().compareTo(word) < 0) {
                    word = entry.getKey();
                }
            }
        }
        System.out.println(records.get(word) + " " + count);
    }
}
