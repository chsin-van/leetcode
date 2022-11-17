import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1704. 判断字符串的两半是否相似 simple
 *
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 *
 * https://modao.cc/app/75c86020e78bb050b35b4cc1a987a2907fa86d61#screen=sky8hgwu1jska2g
 *
 * @author Fzy
 * @since 2022/11/11
 */
public class Leetcode1704 {
    public boolean halvesAreAlike(String s) {
        Set<Character> characters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (characters.contains(s.charAt(i))) {
                if (i < s.length() >> 1) {
                    n++;
                } else {
                    n--;
                }
            }
        }
        return n == 0;
    }
}