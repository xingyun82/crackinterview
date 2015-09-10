package geeksforgeeks;

/**
 * Created by xingyun on 15/9/1.
 */
public class MaxSubarrayCircular {

    public int minSubArray(int[] a) {
        int min = 0;
        int minSofar = Integer.MAX_VALUE;
        for(int i:a) {
            minSofar = (minSofar<0?minSofar:0) + i;
            min = Math.min(minSofar, min);
        }
        return min;
    }

    public int maxSubArray(int[] a) {
        int max = 0;
        int maxSofar = Integer.MIN_VALUE;
        for(int i:a) {
            maxSofar = (maxSofar>0?maxSofar:0) + i;
            max = Math.max(max, maxSofar);
        }
        return max;
    }

    public int maxSubArrayCircular(int[] a) {
        int sum = 0;
        for(int i:a) {
            sum += i;
        }
        System.out.println("sum:" + sum);
        int maxSubSum = maxSubArray(a);
        System.out.println("max sub sum:" + maxSubSum);
        int minSubSum = minSubArray(a);
        System.out.println("min sub sum:" + minSubSum);
        return Math.max(maxSubSum, sum-minSubSum);
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, -1, -1, -1};
        MaxSubarrayCircular inst = new MaxSubarrayCircular();
        System.out.println(inst.maxSubArrayCircular(a));
    }
}
