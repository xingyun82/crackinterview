package array;

/**
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 * Created by xingyun on 15/8/19.
 */
public class LC_33_SearchInRotatedSortedArray {

    public int binarySearch(int[] A, int start, int end, int target) {
        if (start>end) return -1;
        //if (start == end) return target == A[start]?start:-1;
        int mid = ((start+end))/2;
        if (A[mid] == target) return mid;
        if (A[start] > A[end]) {
            if (A[mid] > target) {
                return binarySearch(A, mid+1, end, target);
            } else if(A[mid] < target){
                return binarySearch(A, start, mid-1, target);
            }
        } else if (A[start] < A[end]) {
            if (A[mid] > target) {
                return binarySearch(A, start, mid-1, target);
            } else if(A[mid] < target){
                return binarySearch(A, mid+1, end, target);
            }
        }
        return -1;
    }

    public int search(int[] A, int start, int end, int target) {
        //if (start == end) return A[start] == target?start:-1;
        if (start>end) return -1;
        int mid = (start+end)/2;
        if (A[start] < A[end]) {
            if (A[mid] <= A[start]) {
                int tgt1 = binarySearch(A, start, mid, target);
                if (tgt1 != -1) return tgt1;
                return search(A, mid+1, end, target);
            } else if (A[mid] >= A[end]) {
                int tgt1 = binarySearch(A, mid, end, target);
                if (tgt1 != -1) return tgt1;
                return search(A, start, mid-1, target);
            } else {
                return binarySearch(A, start, end, target);
            }
        } else {
            if (A[mid] >= A[start]) {
                int tgt1 = binarySearch(A, start, mid, target);
                if (tgt1 != -1) return tgt1;
                return search(A, mid+1, end, target);
            } else if (A[mid] <= A[end]) {
                int tgt1 = binarySearch(A, mid, end, target);
                if (tgt1 != -1) return tgt1;
                return search(A, start, mid-1, target);
            } else {
                return binarySearch(A, start, end, target);
            }
        }

    }

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        return search(A, 0, A.length-1, target);
    }
}
