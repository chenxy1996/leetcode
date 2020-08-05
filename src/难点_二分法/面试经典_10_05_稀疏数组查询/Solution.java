package 难点_二分法.面试经典_10_05_稀疏数组查询;


public class Solution {
    public static int findString(String[] words, String s) {
        int start =  0 ;
        int end = words.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int dummy = mid;
            String val = "";
            while (dummy >= start && (val = words[dummy]).length() == 0) {
                dummy--;
            }
            if (start <= dummy) {
                if (val.equals(s)) {
                    return dummy;
                }
                if (val.compareTo(s) < 0) {
                    start = mid + 1;
                } else {
                    end = dummy - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] ss = {"AX zEfzhxdXXbeCQOKa", "aLRAEYPIZokU", "giqyZpvcOHdfPpRqHAD", "mhQf", "uwIPRHFftk"};
        String target = "btRVwblGdpLTtSLbjFzB";
        System.out.println(findString(ss, target));
    }
}
