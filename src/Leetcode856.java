import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 856. 括号的分数
 *
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 * 链接：https://leetcode.cn/problems/score-of-parentheses
 *
 * @author Fzy
 * @since 2022/10/9
 */
public class Leetcode856 {
    public int scoreOfParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int offset = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (list.isEmpty() || chars[i] == '(') {
                list.push(chars[i]);
            } else {
                Character pop = list.pop();
                int present;
                if (pop == '(') {
                    present = 1;
                } else {
                    present = pop * 2;
                    offset *= 2;
                    list.pop();
                }
                if (list.peek() != null && list.peek() != '(') {
                    list.push((char) ((int) list.pop() + present));
                } else {
                    list.push((char)present);
                }
                if (list.peek() == '(' && i < chars.length - 1) {
                    list.push((char)(list.pop() + 1));
                    offset = 1;
                }
            }
        }
        return list.peek() - offset;
    }

    public int scoreOfParentheses1(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode856().scoreOfParentheses("((((((())))()())))"));
    }
}