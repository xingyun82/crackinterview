package bitmagic;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Created by xingyun on 15/6/28.
 */
public class LC_137_SingleNumberII {

    /*
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i++) {
            twos |= ones & nums[i];
            ones ^= nums[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
    */

    public int singleNumber(int[] A) {
        int res = 0;
        int count = 0;

        for (int i=0; i<32; i++){
            count = 0;
            for (int j=0; j<A.length; j++){
                count += ((A[j] >>> i) & 1);
            }
            if(count%3 == 1) {
                res = res | (1 << i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 3, 3, 1, 3};
        LC_137_SingleNumberII inst = new LC_137_SingleNumberII();
        System.out.println(inst.singleNumber(nums));
    }
}
