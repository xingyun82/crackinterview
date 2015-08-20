package array;

/**
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * Created by xingyun on 15/8/19.
 */
public class LC_26_RemoveDuplicates {

    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int i = 0;
        for (int j=0; j<A.length; j++) {
            if (A[i] != A[j]) i++;
            A[i] = A[j];
        }
        return i+1;
    }

}
