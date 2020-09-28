import java.sql.Array;
import java.util.*;

public class Solution {
    public static List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            int val = nums[i];
            Iterator<Integer> iterator = map.headMap(val, false).values().iterator();
            int cnt = 0;
            while (iterator.hasNext()) {
                cnt += iterator.next();
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
            res.add(0, cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
    }
}
