package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 From Twitter:

 A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0..N−1]. Sets S[K] for 0 ≤ K < N are defined as follows: S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }. Sets S[K] are finite for each K.

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A consisting of N integers, returns the size of the largest set S[K] for this array. The function should return 0 if the array is empty.

 */
public class ArrayLargestSet {

    public int solution(int[] A) {
        // use a map to store all possible subset
        Map<Integer, Set<Integer>> sMap = new HashMap<>();
        int maxSize = 0;
        for (int i = 0; i<A.length; ++i) {
            int index = i;
            if(!sMap.containsKey(A[index])) {
                Set<Integer> set = new HashSet<>();
                while(!set.contains(A[index])) {
                    set.add(A[index]);
                    sMap.put(A[index], set);
                    index = A[index];
                }
                maxSize = Math.max(maxSize, set.size());
            }
        }
        return maxSize;
    }

    public int solution2(int[] A) {
        int maxSize = 0;
        int count, index, j;
        // use "-1" mark if this element has been accessed.
        for (int i=0; i<A.length; ++i) {
            index = i;
            count = 0;
            while (A[index] != -1) {
                count++;
                j = index;
                index = A[index];
                A[j] = -1;
            }
            maxSize = Math.max(maxSize, count);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int A[] = {3, 5, 2, 1, 4, 0};
        ArrayLargestSet inst = new ArrayLargestSet();
        System.out.println(inst.solution2(A));
    }
}
