package array;

/**
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 * Created by xingyun on 15/3/7.
 */
public class LC_35_SearchInsert {

    public int searchInsert(int[] A, int target) {
        if (A == null) return -1;
        if (A.length == 0) return 0;
        return doSearchInsert(A, 0, A.length-1, target);

    }

    public int doSearchInsert(int[] A, int low, int high, int target) {
        //if (low < 0) return 0;
        //if (high >= A.length) return A.length;
        if (low+1 == high) {
            if (A[low] >= target) return low;
            if (target <= A[high]) return high;
            if (target > A[high]) return high+1;
        }
        if (low == high) {
            if (A[low] >= target) return low;
            return high+1;
        }
        while (low < high) {
            int mid = (low+high)/2;
            if (A[mid] == target) return mid;
            if (A[mid] < target) return doSearchInsert(A, mid+1, high, target);
            return doSearchInsert(A, low, mid-1, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{};
        LC_35_SearchInsert inst = new LC_35_SearchInsert();
        int res = inst.searchInsert(A, 7);
        System.out.println(res);
    }

}
