package dp;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 * Created by xingyun on 15/7/31.
 */
public class LC_72_EditDistance {

    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) return 0;
        if(word1 == null) return word2.length();
        if(word2 == null) return word1.length();
        int[][] distMatrix = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<distMatrix.length; ++i) {
            distMatrix[i][0] = i;
        }
        for(int j=0; j<distMatrix[0].length; ++j) {
            distMatrix[0][j] = j;
        }
        for(int i=1; i<distMatrix.length; ++i) {
            for(int j=1; j<distMatrix[0].length; ++j) {
                distMatrix[i][j] = Math.min(
                        Math.min(distMatrix[i-1][j], distMatrix[i][j-1])+1,
                        distMatrix[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)?0:1)
                );
            }
        }
        return distMatrix[word1.length()][word2.length()];
    }


}
