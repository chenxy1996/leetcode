package 小米校招.有效字符串;

import javax.swing.text.html.ListView;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.length() == 0) {
                System.out.println(true);
            } else {
                System.out.println(isValid(s));
            }

        }
    }

    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.addLast(c);
            } else {
                if (c == ')' && stack.peekLast() != '(') {
                    return false;
                }
                if (c == ']' && stack.peekLast() != '[') {
                    return false;
                }
                if (c == '}' && stack.peekLast() != '{') {
                    return false;
                }
                stack.removeLast();
            }
        }
        return stack.isEmpty();
    }
}
