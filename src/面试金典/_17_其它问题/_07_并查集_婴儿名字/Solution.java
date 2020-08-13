package 面试金典._17_其它问题._07_并查集_婴儿名字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // todo
    public static String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> frequencies = new HashMap<>();
        Map<String, String> tree = new HashMap<>();
        for (String name : names) {     //统计频率
            int idx1 = name.indexOf('(');
            int idx2 = name.indexOf(')');
            int frequency = Integer.valueOf(name.substring(idx1 + 1, idx2));
            frequencies.put(name.substring(0, idx1), frequency);
        }
        for (String pair : synonyms) {  //union同义词
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            while (tree.containsKey(name1)) {   //找name1祖宗
                name1 = tree.get(name1);
            }
            while (tree.containsKey(name2)) {   //找name2祖宗
                name2 = tree.get(name2);
            }
            if (!name1.equals(name2)) {   //祖宗不同，要合并
                int frequency = frequencies.getOrDefault(name1, 0) + frequencies.getOrDefault(name2, 0);    //出现次数是两者之和
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                tree.put(nickName, trulyName);      //小名作为大名的分支，即大名是小名的祖宗
                frequencies.remove(nickName);       //更新一下数据
                frequencies.put(trulyName, frequency);
            }
        }

        String[] res = new String[frequencies.size()];
        int index = 0;
        for (String name : frequencies.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            sb.append(frequencies.get(name));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        System.out.println(Arrays.toString(trulyMostPopular(names, synonyms)));
    }
}
