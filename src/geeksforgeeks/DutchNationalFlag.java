package geeksforgeeks;

/**
 * 荷兰国旗问题扩展到4色的算法
 * Created by xingyun on 15/9/4.
 */
public class DutchNationalFlag {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // suppose nums is an array of 0s, 1s, 2s, and 3s, sort the array in place
    public void sort(int[] nums) {
        int l = 0, k = 0, m = 0, h = nums.length - 1;
        while(m <= h) {
            if(nums[m]== 0) {
                swap(nums, m, k);
                swap(nums, l, k);
                m++;
                l++;
                k++;
            } else
            if(nums[m] == 1) {
                swap(nums, m, k);
                m++;
                k++;
            } else if(nums[m] == 2) {
                m++;
            } else if(nums[m] == 3) {
                swap(nums, m, h);
                h--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 0,3, 0, 1,2,0,1,3,1, 1, 2, 2};
        DutchNationalFlag inst = new DutchNationalFlag();
        inst.sort(a);
        for(int i:a) {
            System.out.print(i+" ");
        }
    }
}
