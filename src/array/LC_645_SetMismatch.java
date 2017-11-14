package array;

public class LC_645_SetMismatch {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] findErrorNums(int[] nums) {
        int[] output = new int[2];
        for (int i=0; i<nums.length; ++i) {
            while (nums[i]-1 != i && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i=0; i<nums.length; ++i) {
            if (nums[i]-1 != i) {
                output[0] = nums[i];
                output[1] = i+1;
                break;
            }
        }
        return output;
    }

    // Index Array:
//    public int[] findErrorNums(int[] nums) {
//        int[] arr = new int[nums.length+1];
//        int a=0,b=arr.length;
//        for(int i: nums) arr[i]++;
//
//        for(int j=1;j<arr.length;j++){
//            if(arr[j]==2) a=j;
//            if(arr[j]==0) b=j;
//        }
//        return new int[]{a,b};
//    }


    public static void main(String[] args) {
        LC_645_SetMismatch inst = new LC_645_SetMismatch();
        int[] nums = {4,2,1,2};
        int[] output = inst.findErrorNums(nums);
        System.out.println(output[0] + "," + output[1]);
    }
}
