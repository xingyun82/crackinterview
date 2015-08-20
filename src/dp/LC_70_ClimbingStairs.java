package dp;

/**
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 * Created by xingyun on 15/8/19.
 */
public class LC_70_ClimbingStairs {

    // s(i) = s(i-1) + s(i-2)
    public int climbStairs(int n) {
        if(n < 2) return 1;
        int s0 = 1;
        int s1 = 1;
        int s = 0;
        for(int i=2; i<=n; ++i) {
            s = s0 + s1;
            s0 = s1;
            s1 = s;
        }
        return s;
    }
}
