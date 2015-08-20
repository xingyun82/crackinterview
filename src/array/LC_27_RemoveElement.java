package array;

/**
 *Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Created by xingyun on 15/8/19.
 */
public class LC_27_RemoveElement {

    public int removeElement(int[] A, int elem) {
        if (A.length == 0) return 0;
        int i=0, j=A.length-1;
        while(i<j) {
            if(A[i] == elem) {
                while(A[j] == elem && j>i) j--;
                if (i<j) {
                    A[i] = A[j];
                    j--;
                }
            }
            if (i>=j) break;
            i++;
        }
        if (A[i] == elem) return i;
        return i+1;
    }

}
