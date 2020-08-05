package 题目._204_计数质数;

public class OptimalSolution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        int cnt = 2;
        boolean[] table = new boolean[n]; // 某个数是否为合数
        for (int i = 2; i <= 3; i++) {
            set(table, 2, n);
        }

        for (int i = 5; i < n; i += 6) {
            if (table[i] == false) {
                cnt++;
                set(table, i, n);
            }
            if (i + 2 < n && table[i + 2] == false) {
                cnt++;
                set(table, i + 2, n);
            }
        }
        return cnt;
    }

    private void set(boolean[] table, int k, int n) {
        if (k > Math.sqrt(Integer.MAX_VALUE)) {
            return;
        }
        for (int i = k * k; i > 0 && i < n; i += k) {
            if ((i + 1) % 6 == 0 || (i - 1) % 6 == 0) {
                table[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        OptimalSolution os = new OptimalSolution();
        Solution s = new Solution();
        int n = 499979;
        System.out.println(os.countPrimes(n));
        System.out.println(s.countPrimes(n));
//        System.out.println(oss);
//        List<Integer> ss = s.store;
//        System.out.println(oss.size());
//        System.out.println(ss.size());
//        for (int i = 0; i < ss.size(); i++) {
//            int num = ss.get(i);
//            int res = Collections.binarySearch(oss, num);
//            if (res < 0) {
//                System.out.println(num);
//            }
//        }
//        203897
//        262147
//        299281

    }
}
