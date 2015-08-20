package array;

/**
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 * Created by xingyun on 15/8/19.
 */
public class LC_31_NextPermutation {

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public void nextPermutation(int[] num) {
        int i = num.length-1;
        while(i>0) {
            if(num[i]>num[i-1]) {
                break;
            }
            i--;
        }
        if (i!=0) {
            //swap(num, i-1, i);
            int j=num.length-1;
            while(j>=i) {
                if(num[j]>num[i-1]) {
                    break;
                }
                j--;
            }
            swap(num, i-1,j);
        }
        int start = i;
        int end = num.length-1;
        while(start <= end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }
}
