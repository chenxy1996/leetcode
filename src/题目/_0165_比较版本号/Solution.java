package 题目._0165_比较版本号;

public class Solution {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int e1 = v1.length - 1;
        int e2 = v2.length - 1;
        while (e1 >= 0 && Integer.valueOf(v1[e1]) == 0) {
            e1--;
        }
        while (e2 >= 0 && Integer.valueOf(v2[e2]) == 0) {
            e2--;
        }

        int i;
        for(i = 0; i <= e1 && i <= e2; i++) {
            int n1 = Integer.valueOf(v1[i]);
            int n2 = Integer.valueOf(v2[i]);
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
        }

        if (i > e1 && i > e2) {
            return 0;
        }
        if (i <= e1 && i > e2) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
//        compareVersion("1", "0");
        System.out.println(Integer.valueOf("0000"));
    }
}
