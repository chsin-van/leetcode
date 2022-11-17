import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 792. 匹配子序列的单词数 normal
 *
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * 例如， “ace” 是 “abcde” 的子序列。
 *
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 *
 * https://leetcode.cn/problems/number-of-matching-subsequences/
 *
 * @author Fzy
 * @since 2022/11/17
 */
public class Leetcode792 {
    // 超时
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            int i = 0, j = 0;
            while (true) {
                if (s.charAt(i++) == word.charAt(j)) {
                    j++;
                }
                if (j >= word.length()) {
                    res++;
                    break;
                } else if (i >= s.length()) {
                    break;
                }
            }
        }
        return res;
    }

    // HashSet查找
    public int numMatchingSubseq1(String s, String[] words) {
        int res = 0;
        HashSet<String> containSet = new HashSet<>();
        HashSet<String> notContainSet = new HashSet<>();
        for (String word : words) {
            if (containSet.contains(word)) {
                res++;
                continue;
            } else if (notContainSet.contains(word)) {
                continue;
            }
            int i = 0, j = 0;
            while (true) {
                if (s.charAt(i++) == word.charAt(j)) {
                    j++;
                }
                if (j >= word.length()) {
                    res++;
                    containSet.add(word);
                    break;
                } else if (i >= s.length()) {
                    notContainSet.add(word);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}