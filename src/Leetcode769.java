import java.util.LinkedList;

/**
 * 769. 最多能完成排序的块
 *
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * 返回数组能分成的最多块数量。
 *
 * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
 *
 * @author Fzy
 * @since 2022/10/13
 */
public class Leetcode769 {
    public int maxChunksToSorted(int[] arr) {
        // todo error
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] > stack.peek()) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                stack.push(arr[i]);
            }
        }
        return stack.size();
    }
}