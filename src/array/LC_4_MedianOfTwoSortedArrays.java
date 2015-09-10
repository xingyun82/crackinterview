package array;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Created by xingyun on 15/8/19.
 */
public class LC_4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {

        int m = A.length;
        int n = B.length;
        int k1 = (m+n+1)>>1;
        int k2 = (m+n+2)>>1;
        return (kthNumber(A, B, 0, m, 0, n, k1) + kthNumber(A, B, 0, m, 0, n, k2))/2.0;
    }

    /**
     *
     * @param A 数组A
     * @param B 数组B
     * @param al A的初始下标
     * @param m  A的数长度
     * @param bl B的初始下标
     * @param n  B的数长度
     * @param k  第k个数
     * @return
     */
    public double kthNumber(int A[], int B[], int al, int m, int bl, int n, int k) {
        if(m > n) return kthNumber(B, A, bl, n, al, m, k);
        if(m == 0) return B[bl+k-1];
        if(k == 1) return Math.min(A[al], B[bl]);
        int i = Math.min(m, k/2);
        int j = k-i;

        if(A[al+i-1] > B[bl+j-1]) {
            return kthNumber(A, B, al, i, bl+j, n-j, k-j);
        } else {
            return kthNumber(A, B, al+i, m-i, bl, j, k-i);
        }
    }


    /*
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
    */

    public static void main(String[] args) {
        LC_4_MedianOfTwoSortedArrays inst = new LC_4_MedianOfTwoSortedArrays();
        int[] A = {1,2};
        int[] B = {1,1};
        System.out.println(inst.findMedianSortedArrays(A, B));

    }
}
