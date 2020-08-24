package 剑指offer二刷_20200806._38_08_实现起来很麻烦_第K个排列;

public class Solution {
    public static String getPermutation(int n, int k) {
        int prod= 1;
        for(int i = 1; i <= n; i++) {
            prod *= i;
        }
        StringBuilder ans = new StringBuilder();
        boolean[] map = new boolean[n + 1];
        while (n > 0) {
            int slotSize = prod / n;
            int l = 1;
            int r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (k <= slotSize * m) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            k -= slotSize * (l - 1);
            int p = 0;
            for(int i = 0; i < map.length; i++) {
                if (map[i] == false) {
                    if (p == l) {
                        p = i;
                        break;
                    }
                    p++;
                }
            }
            map[p] = true;
            ans.append(p);
            prod = slotSize;
            n--;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        System.out.println(getPermutation(n, k));
    }
}
