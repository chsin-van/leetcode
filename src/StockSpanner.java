import java.util.ArrayList;
import java.util.List;

/**
 * 901. 股票价格跨度
 *
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * 示例：
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *
 * 链接：https://leetcode.cn/problems/online-stock-span
 *
 * @author Fzy
 * @since 2022/10/21
 */
public class StockSpanner {
    private final List<Integer> stockPrices;

    public StockSpanner() {
        stockPrices = new ArrayList<>();
    }

    public int next(int price) {
        stockPrices.add(price);
        int res = 1;
        for (int i = stockPrices.size() - 2; i >= 0; i--) {
            if (stockPrices.get(i) <= price) {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.log(4) / Math.log(2));
    }
}