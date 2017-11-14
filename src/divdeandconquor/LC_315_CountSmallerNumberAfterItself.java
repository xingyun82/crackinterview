package divdeandconquor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].
 */
public class LC_315_CountSmallerNumberAfterItself {

    class Pair {
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Pair[] arr = new Pair[nums.length];
        int[] smaller = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        mergeSort(arr, smaller);
        res.addAll(Arrays.stream(smaller).boxed().collect(Collectors.toList()));
        return res;
    }

//    private Pair[] mergeSort(Pair[] arr, int[] smaller) {
//        if (arr.length <= 1) {
//            return arr;
//        }
//        int mid = arr.length / 2;
//        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
//        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);
//        for (int i = 0, j = 0; i < left.length || j < right.length;) {
//            if (j == right.length || i < left.length && left[i].val <= right[j].val) {
//                arr[i + j] = left[i];
//                smaller[left[i].index] += j;
//                i++;
//            } else {
//                arr[i + j] = right[j];
//                j++;
//            }
//        }
//        return arr;
//    }

    private Pair[] mergeSort(Pair[] arr, int[] smaller) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);
        merge(left, right, arr, smaller);
        return arr;
    }

    private void merge(Pair[] left, Pair[] right, Pair[] arr, int[] smaller) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].val <= right[j].val) {
                smaller[left[i].index] += j;
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];

            }
        }
        while (i<left.length) {
            smaller[left[i].index] += j;
            arr[k++] = left[i++];
        }
        while (j<right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 5, 1};
        LC_315_CountSmallerNumberAfterItself inst = new LC_315_CountSmallerNumberAfterItself();
        System.out.println(inst.countSmaller(nums));
    }

}
