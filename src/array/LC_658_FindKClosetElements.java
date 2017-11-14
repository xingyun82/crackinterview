package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_658_FindKClosetElements {


//    // 1. binary search for x
//    // 2. get left k-1 elements and right k-1 elements
//    // 3. find the closest elements(two pointers)
//    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
//        int idx = binarySearch(arr, x);
//        System.out.println("idx:" + idx);
//        int lidx = 0, ridx = 0;
//        List<Integer> result = new ArrayList<>();
//        if (arr.get(idx) == x) {
//            lidx = idx - 1;
//            ridx = idx + 1;
//            result.add(x);
//        } else {
//            lidx = idx - 1;
//            ridx = idx;
//        }
//
//        while (lidx >= 0 && ridx < arr.size()  && result.size() < k) {
//            int labs = Math.abs(arr.get(lidx) - x);
//            int rabs = Math.abs(arr.get(ridx) - x);
//            if (labs > rabs) {
//                result.add(arr.get(ridx++));
//            } else {
//                result.add(0, arr.get(lidx--));
//            }
//
//        }
//        if (result.size() == k) {
//            return result;
//        }
//
//        if (lidx < 0) {
//            return arr.subList(0, k);
//        }
//
//        if (ridx == arr.size()) {
//            return arr.subList(arr.size() - k, arr.size());
//        }
//        return null;
//    }
//
//    private int binarySearch(List<Integer> arr, int x) {
//        int l = 0, r = arr.size() - 1;
//        int mid = 0;
//        while (l <= r) {
//            mid = (l+r)/2;
//            if (arr.get(mid) == x) {
//                break;
//            } else if (arr.get(mid) > x) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return mid;
//    }

    // another solution from leetcode
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int start = 0, end = arr.size() - k;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(x - arr.get(mid) > arr.get(mid + k) - x) {
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return arr.subList(start, start + k);
    }

    /**
     * navie solution.
     * time: O(nlogn)
     * space: O(k)
     */
    public List<Integer> findClosestElements0(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
        arr = arr.subList(0,k);
        Collections.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(0,1,1,1,2,3,6,7,8,9);
//        List<Integer> arr = Arrays.asList(1,2,3,4,5);
        LC_658_FindKClosetElements inst = new LC_658_FindKClosetElements();
        System.out.println(inst.findClosestElements(arr, 9, 4));
        System.out.println(inst.findClosestElements0(arr, 9, 4));
    }
}
