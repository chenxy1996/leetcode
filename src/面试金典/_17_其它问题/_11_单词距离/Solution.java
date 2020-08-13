package 面试金典._17_其它问题._11_单词距离;

public class Solution {
    public static int findClosest(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                p1 = i;
            }
            if (word.equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min == words.length ? -1 : min;
    }

    public static void main(String[] args) {
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        System.out.println(findClosest(words, "a", "student"));
    }
}
