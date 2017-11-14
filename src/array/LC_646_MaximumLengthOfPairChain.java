package array;

import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

 Example 1:
 Input: [[1,2], [2,3], [3,4]]
 Output: 2
 Explanation: The longest chain is [1,2] -> [3,4]

 */
public class LC_646_MaximumLengthOfPairChain {

    /**
     * Greedy algorithm!
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]); // sort by right, not left!
        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) {
            sum++;
            int curEnd = pairs[i][1];
            while (i+1 < n && pairs[i+1][0] <= curEnd) i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,3}, {2,4}, {4, 8}, {5,6},{7,8}, {9, 10}};
        LC_646_MaximumLengthOfPairChain inst = new LC_646_MaximumLengthOfPairChain();
        System.out.println(inst.findLongestChain(pairs));
    }
}
