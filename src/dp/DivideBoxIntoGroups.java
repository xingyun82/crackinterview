package dp;

/**
 * Created by xingyun on 15/9/9.
 */
public class DivideBoxIntoGroups {

    // diff[i][p][q] = min {
    //                      abs(diff[i-1][p-1][q] + a[i]), // i in group 0 (n/2)
    //                      abs(diff[i-1][p][q-1] + a[i])  // j in group 1 (n-n/2)
    //                      }   // if p< n/2 and q< n-n/2
    //               = abs(diff[i-1][p-1][q] + a[i])  // q == n-n/2
    //               = abs(diff[i-1][p][q-1] + a[i])  // p = n/2

    // 先求出diff[n][n/2][n-n/2], 然后反推分组情况

    public int minDiff(int[] A) {

        int N = A.length;
        int G1 = N/2;
        int G2 = N-N/2;
        int[][] diff = new int[G1+1][G2+1];

        /*
        for(int p=0; p<=G1; p++) {
            for(int q=0; q<=G2; q++) {
                // special cases
                if(p+q == 0) continue;
                if(p == 0) {
                    diff[p][q] = Math.abs( diff[p][q-1] + A[p+q-1]);
                } else
                if(q == 0) {
                    diff[p][q] = Math.abs( diff[p-1][q] + A[p+q-1]);
                } else {
                    diff[p][q] = Math.min( Math.abs( diff[p][q-1] + A[p+q-1]), Math.abs( diff[p-1][q] + A[p+q-1]));
                }
            }
        }
        */

        return diff[G1][G2];
    }

    public static void main(String[] args) {
        DivideBoxIntoGroups inst = new DivideBoxIntoGroups();
        int[] A = {6,12,5};
        System.out.println(inst.minDiff(A));
    }
}
