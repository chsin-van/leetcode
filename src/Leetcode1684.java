/**
 * 1684. 统计一致字符串的数目 simple
 *
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 * 示例 1：
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 *
 * 链接：https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 *
 * @author Fzy
 * @since 2022/11/8
 */
public class Leetcode1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        loop: for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!allowed.contains(String.valueOf(word.charAt(i)))) {
                    continue loop;
                }
            }
            res++;
        }
        return res;
    }
}