package 美团.借书;

import java.util.*;

public class Main {
    private Set<Integer> locked = new HashSet<>();
    private Map<Integer, Integer> pos = new HashMap<>();
    private Set<Integer> oth = new HashSet<>();

    private  void process(int[] op) {
        if (op[0] == 1) {
            if (!locked.contains(op[2]) && !oth.contains(op[1])) {
                int p = pos.getOrDefault(op[1], -1); // 是否在别的书架上
                if (p == -1) {
                    pos.put(op[1], op[2]);
                } else if (p != op[2] ){
                    if (!locked.contains(p)) { // 原本在别的书架上，没加锁
                        pos.put(op[1], op[2]);
                    }
                }
            }
        } else if (op[0] == 2) {
            locked.add(op[1]);
        } else if (op[0] == 3) {
            if (locked.contains(op[1])) {
                locked.remove(op[1]);
            }
        } else if (op[0] == 4) {
            int p = pos.getOrDefault(op[1], -1);
            if (p == -1 || locked.contains(p)) {
                System.out.println(-1);
            } else {
                oth.add(op[1]);
                pos.remove(op[1]);
                System.out.println(p);
            }
        } else if (op[0] == 5) {
            if (oth.contains(op[1])) {
                oth.remove(op[1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();
        Main main = new Main();
        for(int i = 0; i < Q; i++) {
            int command = scanner.nextInt();
            int[] op;
            int cnt;
            if (command == 1) {
                op = new int[3];
                cnt = 2;
            } else {
                op = new int[2];
                cnt = 1;
            }
            op[0] = command;
            int p = 1;
            for(int j = 0; j < cnt; j++) {
                op[p++] = scanner.nextInt();
            }
            main.process(op);
        }
    }
}
