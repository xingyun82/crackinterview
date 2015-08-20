package geeksforgeeks;

/**
 * Created by xingyun on 15/8/14.
 */
public class SequenceNumbers {

    public int seqNumbers(int n1, int n2, int n3) {
        int[][][] D1 = new int[n1+1][n2+1][n3+1];
        int[][][] D2 = new int[n1+1][n2+1][n3+1];
        int[][][] D3 = new int[n1+1][n2+1][n3+1];

        D1[1][0][0] = 1;
        D2[0][1][0] = 1;
        D3[0][0][1] = 1;

        for(int i=0; i<=n1; ++i) {
            for(int j=0; j<=n2; ++j) {
                for(int k=0; k<=n3; ++k) {
                    if(i +j+k <= 1) continue;
                    if(i>0) D1[i][j][k] = D2[i-1][j][k] + D3[i-1][j][k];
                    if(j>0) D2[i][j][k] = D1[i][j-1][k] + D3[i][j-1][k];
                    if(k>0) D3[i][j][k] = D1[i][j][k-1] + D2[i][j][k-1];
                }
            }
        }
        return D1[n1][n2][n3] + D2[n1][n2][n3] + D3[n1][n2][n3];
    }


    public static void main(String[] args) {
        SequenceNumbers inst = new SequenceNumbers();
        System.out.println(inst.seqNumbers(1,1,2));
    }
}
