package dp;

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 * Created by xingyun on 15/8/19.
 */
public class LC_123_SellStockIII {

    public int maxProfit(int[] prices) {
        if (prices.length<2) return 0;
        int len=prices.length,result=0;
        int low=prices[0],high=prices[len-1];

        // 一次交易的最大差值
        int profits_history[] = new int[len];

        for (int i=0;i<len;i++){
            low=Math.min(low,prices[i]);
            result=Math.max(result,prices[i]-low);
            profits_history[i]=result;
        }

        for (int i=len-1;i>=0;i--){
            high=Math.max(high,prices[i]);
            result=Math.max(result,high-prices[i]+profits_history[i]);
        }
        return result;
    }

}
