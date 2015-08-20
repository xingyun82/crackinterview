package array;

/**
 *
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 * Created by xingyun on 15/3/8.
 */
public class LC_41_FirstMissingPositive {

    public int firstMissingPositive(int A[], int n)
    {
        for(int i = 0; i < n; ++ i)
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                //swap(A[i], A[A[i] - 1]);
                int j = A[i]-1;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,4,-1,1};
        LC_41_FirstMissingPositive inst = new LC_41_FirstMissingPositive();
        System.out.println(inst.firstMissingPositive(A, A.length));
    }
}
