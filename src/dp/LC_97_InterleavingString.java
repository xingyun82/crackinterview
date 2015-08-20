package dp;

/**
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 * Created by xingyun on 15/8/19.
 */
public class LC_97_InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        if(s1 == null) {
            if(s2 == null) return s3 == null;
            else return s2.equals(s3);
        }
        if(s2 == null) {
            return s1.equals(s3);
        }
        if(s3 == null) return false;
        */
        int m = s1.length();
        int n = s2.length();
        if(s3.length() != m+n) return false;

        boolean[][] matrix = new boolean[m+1][n+1];
        for(int i=0; i<m+1; ++i) {
            for(int j=0; j<n+1; ++j) {
                if(i == 0 && j == 0) matrix[i][j] = true;
                else if(i==0) {
                    matrix[i][j] = matrix[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1));
                }
                else if(j==0) {
                    matrix[i][j] = matrix[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1));
                } else {
                    matrix[i][j] = (matrix[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1) )) ||
                            (matrix[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
                }
            }
        }
        return matrix[m][n];
    }

}
