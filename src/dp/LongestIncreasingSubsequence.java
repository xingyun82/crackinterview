package dp;

/**
 * Created by xingyun on 15/9/11.
 */
public class LongestIncreasingSubsequence {

    //
    // S[i] = max{ S[i], S[j]+1 }  if A[j] < A[i]
    public int getLongestIncrSeq(int[] A) {
        int n = A.length;
        int[] S = new int[n];
        for(int i=0; i<n; ++i) {
            S[i] = 1;
        }
        for(int i=0; i<n; ++i) {
            for(int j=0; j<i; ++j) {
                if(A[j] < A[i]) {
                    S[i] = Math.max(S[i], S[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=0; i<n; ++i) {
            max = Math.max(max, S[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {3,4,-1,0,6,2,3};
        LongestIncreasingSubsequence inst = new LongestIncreasingSubsequence();
        System.out.println(inst.getLongestIncrSeq(A));
    }
}
