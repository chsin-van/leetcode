/**
 * @description: LeetCode1476 商品折扣后的最终价格 simple
 * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * @since: 2022/9/1
 * @author: Fzy
 */
public class Leetcode1476 {
    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}