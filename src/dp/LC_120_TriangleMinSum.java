package dp;

import java.util.*;
/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 * Created by xingyun on 15/7/10.
 */
public class LC_120_TriangleMinSum {

    /**
     * 递归的方法比较直观，但一般性能不被接受，尽量改造成非递归的方法
     *
    public int minSum(List<List<Integer>> triangle, int row, int col) {
        if(row == triangle.size()) return 0;
        int res = triangle.get(row).get(col), leftMin, rightMin;
        leftMin = minSum(triangle, row+1, col);
        rightMin = minSum(triangle, row+1, col+1);
        return res+Math.min(leftMin, rightMin);
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 ||
                triangle.get(0) == null || triangle.get(0).size() == 0) return 0;
        return minSum(triangle, 0, 0);
    }
    */


    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null || triangle.size() == 0 ||
                triangle.get(0) == null || triangle.get(0).size() == 0) return 0;

        int[] minSum = new int[triangle.size()];
        for(int i=0;i<triangle.size(); ++i) minSum[i] = triangle.get(triangle.size()-1).get(i);

        for(int i=triangle.size()-2; i>=0; --i) {
            for(int j=0; j<triangle.get(i).size(); ++j) {
                minSum[j] = triangle.get(i).get(j) + Math.min(minSum[j], minSum[j+1]);
            }
        }
        return minSum[0];
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,1));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        LC_120_TriangleMinSum inst = new LC_120_TriangleMinSum();
        System.out.println(inst.minimumTotal(triangle));
    }
}
