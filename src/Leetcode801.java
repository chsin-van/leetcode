/**
 * 801. 使序列递增的最小交换次数
 *
 * 我们有两个长度相等且不为空的整型数组nums1和nums2。在一次操作中，我们可以交换nums1[i]和nums2[i]的元素。
 *
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增所需操作的最小次数 。
 *
 * 数组arr严格递增 且arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1]。
 * 链接：https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 *
 * @author Fzy
 * @since 2022/10/10
 */
public class Leetcode801 {

    public int minSwap(int[] nums1, int[] nums2) {
        // todo error
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < Math.min(nums1.length, nums2.length); i++) {
            if (nums1[i] <= nums1[i - 1] || nums2[i] <= nums2[i - 1]) {
                int t = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = t;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode801().minSwap(new int[]{0, 4, 4, 5, 9}, new int[]{0, 1, 6, 8, 10}));
    }
}