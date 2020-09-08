package 题目._0030_困难_串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 速度最快的别人写
 * 下面的这个滑动窗口用得妙，从后往前，这就比从前往后写简单多了。
 */
public class OptimalSolution {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0){
            return res;
        }

        int n = words.length;
        Map<String , Integer> map = new HashMap<>();
        for(int i = 0 ;i< n ;++i){
            map.put(words[i], map.getOrDefault(words[i], 0 ) + 1);
        }
        int singleWordLen = words[0].length();
        int window = singleWordLen * n;
        for(int i= 0 ;i<singleWordLen;++i){
            int start = i;
            while(start + window <= s.length()){
                String str = s.substring(start, start + window);
                Map<String, Integer> seen = new HashMap<>();
                int j = n;
                while(j > 0 ){
                    String word = str.substring((j-1)*singleWordLen,j*singleWordLen);
                    int count = seen.getOrDefault(word, 0) + 1;
                    if(count > map.getOrDefault(word, 0 )){
                        break;
                    }
                    seen.put(word, count);
                    --j;
                }
                if(j == 0){
                    res.add(start);
                }
                start += singleWordLen * Integer.max(j ,1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abaababbaba";
        String[] words = {"ba","ab","ab"};
        System.out.println(findSubstring(s, words));
    }
}
