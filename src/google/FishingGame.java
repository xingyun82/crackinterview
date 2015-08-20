package google;

/**
 *
 * .有一个游戏，他说是fishing game，给一个数组vector<int> Basket, 比如里面元素
 是{2，3，5，1，3，4，7}
 有A，B 2个player，规定只能从Basket2端选数字，意思就是A开始的话一开始A只能选2
 或者7，然后B选，同样只能2端选。所以比如一开始A选了7，B只能从2和4中选。问给定
 数组A能取的最大值。B的策略已知，是greedy，就是总会取最大的那个数。
 写一个 int maxA（vector<int>& Basket）；

 * Created by xingyun on 15/7/12.
 */
public class FishingGame {

    int MAXNUM;

    public void doFishing(int[] nums, int start, int end) {
        if(start == end) {
            MAXNUM = Math.max(nums[start], MAXNUM);
            return;
        }
        if(start+1 == end) {
            int tmpMax = Math.max(nums[start+1], nums[end]);
            MAXNUM = Math.max(tmpMax, MAXNUM);
            return;
        }
        int tmpMax = nums[start];
        MAXNUM = Math.max(tmpMax, MAXNUM);
        if(nums[start+1] >= nums[end]) {
            doFishing(nums, start+2, end);
        } else {
            doFishing(nums, start+1, end-1);
        }

        tmpMax = nums[end];
        MAXNUM = Math.max(tmpMax, MAXNUM);
        if(nums[start] >= nums[end-1]) {
            doFishing(nums, start+1, end-1);
        } else {
            doFishing(nums, start, end-2);
        }
    }

    public int maxA(int[] nums) {
        doFishing(nums, 0, nums.length-1);
        return MAXNUM;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,9,8,5,2,6,4,8,3};
        FishingGame inst = new FishingGame();
        System.out.println(inst.maxA(nums));
    }
}
