package dp._526_动态规划_状态压缩dp_优美的排列;

public class DpSolution {
    public static int countArrangement(int N) {
        int[] dp = new int[1 << N];
        for (int i = 0; i < N; i++) {
            dp[1 << i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            int cnt = 0;
            int tmp = i;
            while (tmp != 0) { // 看 i 的二进制表示中有多少个 1
                cnt++;
                tmp &= tmp - 1;
            }
            cnt++;
            int k = i;
            for (int j = 1; j <= N; j++) {
                int bit = k & 1;
                k = k >> 1;
                if (bit == 0 && (j % cnt == 0 || cnt % j == 0)) {
                    int p = i | 1 << (j - 1);
                    dp[p] += dp[i];
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(15));
//        System.out.println(1 << 0);
    }
}
