package dp;

/**
 * Created by xingyun on 15/8/17.
 */
public class Linkedin_PaintHouse {

    // main idea: dp
    // suppose totalCost[i][k] is the kth house which paint with ith color
    // then totalCost[i][k] = min_j!=i {totalCost[j][k]} + cost[i][k]

    public int minCost(int n, int m, int[][] cost) {
        int[][] totalCost = new int[m][n];

        int minCost = Math.min(cost[0][0], cost[1][0]);
        int secondMinCost = Math.max(cost[0][0], cost[1][0]);

        for(int i=0; i<m; ++i) {
            totalCost[i][0] = cost[i][0];
            if(totalCost[i][0] < minCost) {
                secondMinCost = minCost;
                minCost = totalCost[i][0];
            }
        }
        for(int k=1; k<n; ++k) {
            for(int i=0; i<m; ++i) {
                if(totalCost[i][k-1] != minCost) {
                    totalCost[i][k] = minCost + cost[i][k];
                } else {
                    totalCost[i][k] = secondMinCost + cost[i][k];
                }
            }

            minCost = Math.min(totalCost[0][k], totalCost[1][k]);
            secondMinCost = Math.max(totalCost[0][k], totalCost[1][k]);

            for(int i=0; i<m; ++i) {
                if(totalCost[i][k] < minCost) {
                    secondMinCost = minCost;
                    minCost = totalCost[i][k];
                }
            }

        }
        return minCost;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int[][] cost = new int[m][n];
        cost[0] = new int[]{1,2,3,4,5};
        cost[1] = new int[]{2,3,4,5,6};
        cost[2] = new int[]{3,4,5,6,7};
        Linkedin_PaintHouse inst = new Linkedin_PaintHouse();
        System.out.println(inst.minCost(n, m, cost));
    }
}
