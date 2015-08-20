package dp;

/**
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 * Created by xingyun on 15/8/19.
 */
public class LC_198_HouseRobber {

    public int rob(int[] num) {
        int res = 0;
        int[] amount = new int[num.length];
        for(int i=0;i<num.length;++i) {
            amount[i] = 0;
        }
        for(int i=0;i<num.length;++i) {
            if (i==0 || i==1) {
                amount[i] = num[i];
            } else if (i == 2) {
                amount[i] = amount[0] + num[i];
            } else {
                amount[i] = Math.max(amount[i-2], amount[i-3])+num[i];
            }
            if (amount[i] > res) {
                res = amount[i];
            }
        }
        return res;
    }
}
