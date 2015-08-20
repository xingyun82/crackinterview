package dp;

/**
 * Created by xingyun on 15/6/2.
 */
public class LC_188_MaxStockProfit4 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len<2) return 0;
        if (k>len/2){ // simple case
            int ans = 0;
            for (int i=1; i<len; ++i){
                ans += Math.max(prices[i] - prices[i - 1], 0);
            }
            return ans;
        }
        int[] hold = new int[k+1];
        int[] rele = new int[k+1];
        for (int i=0;i<=k;++i){
            hold[i] = Integer.MIN_VALUE;
            rele[i] = 0;
        }
        int cur;
        /*
        for (int i=0; i<len; ++i){
            cur = prices[i];
            for(int j=k; j>0; --j){
                rele[j] = Math.max(rele[j], hold[j] + cur);
                hold[j] = Math.max(hold[j], rele[j - 1] - cur);
            }
        }

        */
        for(int i=0;i<len;++i) {
            cur = prices[i];
            for(int j=1;j<=k;++j) {
                hold[j] = Math.max(hold[j], rele[j-1]-cur);
                rele[j] = Math.max(rele[j], hold[j]+cur);
            }
        }
        return rele[k];
    }

    /*
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {

                //tmpMax means the maximum profit of just doing at most i-1 transactions,
                //using at most first j-1 prices,and buying the stock at price[j] - this is used for the next loop.
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }
    */

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{8,3,2,5,4,7,0,7,6,5};
        LC_188_MaxStockProfit4 inst = new LC_188_MaxStockProfit4();
        int res = inst.maxProfit(1, prices);
        System.out.println(res);
    }
}
