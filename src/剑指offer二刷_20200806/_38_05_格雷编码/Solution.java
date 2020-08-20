package 剑指offer二刷_20200806._38_04_格雷编码;

import java.util.ArrayList;
import java.util.List;

/**
 * 89 具体的解法不在此赘述
 */
public class Solution {
    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for(int i = 1; i <= n; i++) {
            int size = ans.size();
            for(int j = size - 1; j >= 0; j--) {
                ans.add((1 << (i - 1)) | ans.get(j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
}
