package geeksforgeeks;

/**
 *
 * 类似这种问题都考虑动态规划解决
 *
 * 微软亚洲研究院电话面试：现在有一堆硬币，假设都是一毛的，一共有N毛钱，游戏的规则如下：
 * 两个小孩从里面拿钱，假设一次只能取1 2 4毛钱，谁拿到最后一枚银币谁输掉比赛。
 * 假设这两个小孩都足够聪明，现在假设A先拿，那么你能预知这个小孩是赢了还是输了吗?
 *
 *
 * Created by xingyun on 15/9/6.
 */
public class GameStrategy {

    /*
    public boolean S(int n) {
        if(n == 1) return false;
        if(n == 2) return true;
        if(n == 3) return true;
        if(n == 4) return false;
        return !S(n-1) || !S(n-2) || !S(n-4);
    }
    */

    public boolean S(int n) {
        boolean[] res = new boolean[n+1];
        res[0] = true;
        res[1] = false;
        res[2] = true;
        res[3] = true;
        res[4] = false;
        for(int i=5; i<=n; ++i) {
            res[i] = !res[n-1] || !res[n-2] || !res[n-4];
        }
        return res[n];
    }



    public static void main(String[] args) {
        GameStrategy inst = new GameStrategy();
        System.out.println(inst.S(10));
    }
}
