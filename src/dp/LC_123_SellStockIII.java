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

    /*
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
    */

    // S[][0] 0
    // S[][1] first buy
    // S[][2] first sell
    // S[][3] second buy
    // S[][4] second sell

    // S[0] = {0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0}

    // S[i][1] = max(S[i-1][1], S[i-1][0]-prcies[i])
    // S[i][2] = max(S[i-1][2], S[i-1][1]+prices[i])

    // 在i个位置，进行第k次买入的最大收益
    // S[i][2k+1] = max(S[i-1][2k+1], S[i-1][2k]  - prcies[i])
    // 在i个位置，进行第k次卖出的最大收益
    // S[i][2k+2] = max(S[i-1][2k+2], S[i-1][2k+1]+ prices[i])


    public int maxProfit(int[] prices, int k) {
        int[][] S = new int[2][2*k+1];
        S[0][0] = 0; //
        for(int i=0; i<k; ++i) {
            S[0][2*i+1] = Integer.MIN_VALUE;  // 第
            S[0][2*i+2] = 0;
        }
        int cur = 0, next = 1; // to reduce space complexity, otherwise we have to define S[prices.length][2*k+1]
        for(int i=0; i<prices.length; ++i) {
            for(int j=0; j<k; ++j) {
                S[next][2*j+1] = Math.max(S[cur][2*j+1], S[cur][2*j] - prices[i]); // the kth buy
                S[next][2*j+2] = Math.max(S[cur][2*j+2], S[cur][2*j+1]+prices[i]); // the kth sell
            }
            int tmp = cur;
            cur = next;
            next = tmp;
        }
        int max = 0;
        for(int i=0; i<k; ++i) {
            max = Math.max(max, S[cur][2*i+2]);
        }
        return max;
    }

    public static void main(String[] args) {
        LC_123_SellStockIII inst = new LC_123_SellStockIII();
        int[] prices = new int[]{1,3,-1,2,4,-4,6};
        int k = 2;
        System.out.println(inst.maxProfit(prices, k));
    }




}
