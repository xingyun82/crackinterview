package hackerrank;

/**
 * 把数组环形移动k个位置
 * Created by xingyun on 15/8/25.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] tmp = new int[k];
        for(int i=0; i<k; ++i) {
            tmp[i] = nums[i];
        }
        for(int i=0; i<n-k; ++i) {
            nums[i] = nums[i+k];
        }
        for(int i=n-k; i<n; ++i) {
            nums[i] = tmp[i-n+k];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,};
        RotateArray inst = new RotateArray();
        inst.rotate(nums, 4);
        for(int i:nums) {
            System.out.print(i+",");
        }
    }
}
