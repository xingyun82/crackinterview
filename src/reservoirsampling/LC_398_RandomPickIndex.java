package reservoirsampling;

import java.util.Random;

public class LC_398_RandomPickIndex {

    int[] nums;
    Random rnd;

    public LC_398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (rnd.nextInt(++count) == 0)
                    result = i;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 3};
        LC_398_RandomPickIndex inst = new LC_398_RandomPickIndex(nums);
        System.out.println(inst.pick(2));
    }
}
