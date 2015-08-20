package greedy;

/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 * Created by xingyun on 15/8/19.
 */
public class LC_45_JumpGameII {

    // 最优解
    public int jump(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int tail = A[0]; // 每一步能到的最远端
        int min = 1;
        int begin = 0;   // 每一步能到的最近端
        while (tail < A.length - 1) {
            int maxPace = 0;
            for (int i = begin ; i <= tail; i++) {
                maxPace = Math.max(maxPace, i + A[i]);
            }
            begin = tail + 1; // 下一步的最近端是当前步最远端+1
            tail = Math.max(tail, maxPace); // 下一步的最远端
            min++;
        }
        return min;
    }
}
