package array;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Created by xingyun on 15/8/19.
 */
public class LC_4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {

        int m = A.length;
        int n = B.length;

        int k = (n+m-1)/2+1;
        return kthNumber(A, B, k);
    }

    public double kthNumber(int A[], int B[], int k) {

        int m = A.length;
        int n = B.length;

        if (m > n) return kthNumber(B, A, k);

        int left = 0, right = Math.min(m, k);

        while(left < right) {
            int mid = left + (right-left)/2;
            int j = k-1-mid;
            if (A[mid] < B[j] || j>= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int Aminus1 = left - 1 >= 0 ? A[left-1]: Integer.MIN_VALUE;
        int Bj = k - 1 - left >= 0 ? B[k-1-left]:Integer.MIN_VALUE;
        int valK = Math.max(Aminus1, Bj);

        if ((n+m)%2 == 1) return valK;

        int valK1 = Math.min(left<m? A[left]:Integer.MAX_VALUE, (k-left)<n?B[k-left]:Integer.MAX_VALUE);
        return (valK+valK1)*1.0/2;

    }
}
