package dp;

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 * Created by xingyun on 15/8/19.
 */
public class LC_121_SellStock {

    public int maxProfit(int[] a) {

        if (a == null || a.length == 0) return 0;

        int tmpMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int delta = Integer.MIN_VALUE;

        for(int i : a)
        {
            if (i < tmpMin)
            {
                tmpMin = i;
            }
            if ((i - tmpMin) > delta)
            {
                max = i;
                delta = i - tmpMin;
                min = tmpMin;
            }
        }
        return delta;
    }

}
