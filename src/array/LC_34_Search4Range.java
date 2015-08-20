package array;

/**
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 * Created by xingyun on 15/8/19.
 */
public class LC_34_Search4Range {


    public int SearchFirst(int[] A, int low, int high, int target) {
        if (A[low] == target) return low;
        if (low <= high) {
            int mid = (low+high)/2;
            if (A[mid] == target) {
                int first = SearchFirst(A, low, mid-1, target);
                return (first == -1)? mid:first;
            } else if (A[mid] < target) {
                return SearchFirst(A, mid+1, high, target);
            } else {
                return -1;
            }
        }
        return -1;
    }

    public int SearchLast(int[] A, int low, int high, int target) {
        if (A[high] == target) return high;
        if (low <= high) {
            int mid = (low+high)/2;
            if (A[mid] == target) {
                int last = SearchLast(A, mid+1, high, target);
                return (last == -1)?mid:last;
            } else if (A[mid] > target) {
                return SearchLast(A, low, mid-1, target);
            } else {
                return -1;
            }
        }
        return -1;
    }

    public int BinarySearch(int[] A, int low, int high, int target) {
        if (low <= high) {
            int mid = (low+high)/2;
            if (A[mid] == target) return mid;
            if (A[mid] > target) {
                return BinarySearch(A, low, mid-1, target);
            } else {
                return BinarySearch(A, mid+1, high, target);
            }
        }
        return -1;
    }

    public int[] searchRange(int[] A, int target) {
        int pivot = BinarySearch(A, 0, A.length-1, target);
        if (pivot == -1) return new int[]{-1, -1};
        int first = SearchFirst(A, 0, pivot, target);
        int last = SearchLast(A, pivot, A.length-1, target);
        return new int[]{first, last};
    }
}
