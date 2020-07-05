<<<<<<< HEAD
package dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * in: "AB"; out: ["AB", "BA"]
 * int: "ABC"; out: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 */

public class _01_abc {

    public static List<String> getAllResult(String src) {
        StringBuilder remain = new StringBuilder(src);
        List<String> result = new LinkedList<>();
        reccur(new StringBuilder(), remain, result);
        return result;
    }

    private static void reccur(StringBuilder temp, StringBuilder remain, List<String> res) {
        if (remain.length() == 0) {
            res.add(temp.toString());
        }

        for (int i = 0; i < remain.length(); i++) {
            char c = remain.charAt(i);

            // 当前字符加入到 temp 中
            temp.append(c);
            // 在 remain 中删除当前字符d
            remain.delete(i, i + 1);

            // 递归
            reccur(temp, remain, res);

            // 递归结束后
            // 将之前被删除的字符 d 重新加入至 remain
            remain.insert(i, c);

            // 将之前加入至 temp 中的当前字符删除
            temp.delete(temp.length() - 1, temp.length());
        }


    }

    public static void main(String[] args) {
        System.out.println(getAllResult("abcd"));
    }
}
=======
package dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * in: "AB"; out: ["AB", "BA"]
 * int: "ABC"; out: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 */

public class _01_abc {

    public static List<String> getAllResult(String src) {
        StringBuilder remain = new StringBuilder(src);
        List<String> result = new LinkedList<>();
        reccur(new StringBuilder(), remain, result);
        return result;
    }

    private static void reccur(StringBuilder temp, StringBuilder remain, List<String> res) {
        if (remain.length() == 0) {
            res.add(temp.toString());
        }

        for (int i = 0; i < remain.length(); i++) {
            char c = remain.charAt(i);

            // 当前字符加入到 temp 中
            temp.append(c);
            // 在 remain 中删除当前字符d
            remain.delete(i, i + 1);

            // 递归
            reccur(temp, remain, res);

            // 递归结束后
            // 将之前被删除的字符 d 重新加入至 remain
            remain.insert(i, c);

            // 将之前加入至 temp 中的当前字符删除
            temp.delete(temp.length() - 1, temp.length());
        }


    }

    public static void main(String[] args) {
        System.out.println(getAllResult("abcd"));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
