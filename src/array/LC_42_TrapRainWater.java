package array;

/**
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * Created by xingyun on 15/3/8.
 */
public class LC_42_TrapRainWater {

    public int getMaxBarIdx(int[] A) {
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (int i=0; i<A.length; ++i) {
            if (A[i] > max) {
                max = A[i];
                res = i;
            }
        }
        return res;
    }


    public int trap(int[] A) {
        // find the max bar
        // from the begin, compute the traprainwater for each bar
        // from the end, compute the traprainwater for each bar
        int trapWater = 0;
        int maxBarIdx = getMaxBarIdx(A);
        int leftBarIdx = 0;
        for (int i=0;i<maxBarIdx;++i) {
            int delta = A[leftBarIdx] - A[i];
            if (delta >= 0) {
                trapWater += delta;
            } else {
                leftBarIdx = i;
            }
        }
        int rightBarIdx = A.length-1;
        for (int i=A.length-1;i>maxBarIdx;--i) {
            int delta = A[rightBarIdx] - A[i];
            if (delta > 0) {
                trapWater += delta;
            } else {
                rightBarIdx = i;
            }
        }
        return trapWater;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        LC_42_TrapRainWater inst = new LC_42_TrapRainWater();
        System.out.println(inst.trap(A));
    }
}
