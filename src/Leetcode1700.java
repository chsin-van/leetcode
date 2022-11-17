import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1700. 无法吃午餐的学生数量
 *
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
 *
 * 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
 * 否则，这名学生会放弃这个三明治并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组students 和sandwiches，
 * 其中sandwiches[i]是栈里面第i个三明治的类型（i = 0是栈的顶部），students[j]是初始队列里第j名学生对三明治的喜好（j = 0是队列的最开始位置）。
 * 请你返回无法吃午餐的学生数量。
 * 链接：https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch
 *
 * @author Fzy
 * @since 2022/10/19
 */
public class Leetcode1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int res = students.length;
        LinkedList<Integer> stack = Arrays.stream(sandwiches).boxed().collect(Collectors.toCollection(LinkedList::new));
        loop: while (!stack.isEmpty()) {
            for (int i = 0; i < students.length; i++) {
                if (stack.peek() == students[i]) {
                    res--;
                    students[i] = -1;
                    stack.pop();
                    continue loop;
                }
            }
            break;
        }
        return res;
    }

    public int countStudents1(int[] students, int[] sandwiches) {
        int res = students.length;
        Map<Integer, Integer> map = new HashMap<>(res);
        for (int student : students) {
            map.compute(student, (k, v) -> v == null ? 1 : ++v);
        }
        for (int sandwich : sandwiches) {
            if (map.containsKey(sandwich) && map.get(sandwich) != 0) {
                map.put(sandwich, map.get(sandwich) - 1);
                res--;
            } else {
                return res;
            }
        }
        return res;
    }

    public int countStudents1Plus(int[] students, int[] sandwiches) {
        int res = students.length;
        int[] ints = new int[2];
        for (int student : students) {
            ints[student]++;
        }
        for (int sandwich : sandwiches) {
            if (ints[sandwich]-- != 0) {
                res--;
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Stream.of("1", "2", "4", "5", "1")
                .collect(Collectors.toMap(Function.identity(), v -> 1, (v1, v2) -> ++v1));
        System.out.println(map);
    }
}