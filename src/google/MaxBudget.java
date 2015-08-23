package google;

import java.util.Arrays;

/**
 * 1. given an array, each element has a cost, given a budget m,
 * find the longest subarray whcih sum is less than budget
 *
 * 2. follow up
 * given a matrix, each element has a cost, given a budget m,
 * find the max area which sum is less than budget
 *
 * Created by xingyun on 15/8/21.
 */
public class MaxBudget {

    // main idea:
    // suppose s[i] is the max sum (less than m) of sub array which starts with i
    // then, s[i] = s[i-1] - a[i-1] + (a[j] + ...) // j is the next to the end of previous longest subarray


    public int maxLenth(int[] nums, int budget) {
        int n = nums.length;
        int[] sum = new int[n];
        int preSum = 0;
        int preEle = 0;
        int prej = 0;
        int maxLen = 0;
        for(int i=0; i<n; ++i) {
            sum[i] = preSum - preEle;
            int j = prej;
            while(j < n) {
                if(sum[i] + nums[j] > budget) break;
                sum[i] += nums[j++];
            }
            maxLen = Math.max(maxLen, j-i);
            preSum = sum[i];
            preEle = nums[i];
            prej = j;
        }
        return maxLen;
    }

    // main idea:
    // for each submatrix(k*n), convert it into an array, and get the max length(maxLen) of that array,
    // then the area is maxLen*k


    public int maxArea(int[][] matrix, int budget) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[n];
        int area = 0;
        for(int k=0; k<m; ++k) {
            Arrays.fill(nums, 0);
            for (int i = k; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    nums[j] += matrix[i][j];
                }
                int tmpArea = maxLenth(nums, budget) * (i - k + 1);
                System.out.println(tmpArea);
                area = Math.max(area, tmpArea);

            }
        }

        return area;
    }

    public static void main(String[] args) {
        /*
        int[] nums = new int[]{1,2,3,4,5,6};
        MaxBudget inst = new MaxBudget();
        System.out.println(inst.maxLenth(nums, 10));
        */

        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1,2,3,4,5,6};
        matrix[1] = new int[]{2,3,4,5,6,7};
        matrix[2] = new int[]{3,4,5,6,7,8};
        MaxBudget inst = new MaxBudget();
        System.out.println(inst.maxArea(matrix, 25));
    }
}
