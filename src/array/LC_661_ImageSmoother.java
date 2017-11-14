package array;

public class LC_661_ImageSmoother {

    private int getElement(int[][] M, int x, int y) {
        int m = M.length;
        int n = M[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return M[x][y];
        }
        return -1;
    }

    public int[][] imageSmoother(int[][] M) {

        int m = M.length;
        int n = M[0].length;
        int[][] result = new int[m][n];
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                int sum = 0;
                int count = 0;
                int n1 = getElement(M, i-1, j-1);
                int n2 = getElement(M, i-1, j);
                int n3 = getElement(M, i-1, j+1);
                int n4 = getElement(M, i, j-1);
                int n5 = getElement(M, i, j+1);
                int n6 = getElement(M, i+1, j-1);
                int n7 = getElement(M, i+1, j);
                int n8 = getElement(M, i+1, j+1);
                sum += (n1 >= 0 ? n1 : 0) +  (n2 >= 0 ? n2 : 0) +  (n3 >= 0 ? n3 : 0) +  (n4 >= 0 ? n4 : 0) +
                        (n5 >= 0 ? n5 : 0) +  (n6 >= 0 ? n6 : 0) +  (n7 >= 0 ? n7 : 0) +  (n8 >= 0 ? n8 : 0);
                count += (n1 >= 0 ? 1 : 0) +  (n2 >= 0 ? 1 : 0) +  (n3 >= 0 ? 1 : 0) +  (n4 >= 0 ? 1 : 0) +
                        (n5 >= 0 ? 1 : 0) +  (n6 >= 0 ? 1 : 0) +  (n7 >= 0 ? 1 : 0) +  (n8 >= 0 ? 1 : 0);
                result[i][j] = (sum+M[i][j])/(count+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,1},{1,0,1},{1,1,1}};
        LC_661_ImageSmoother inst = new LC_661_ImageSmoother();
        inst.imageSmoother(M);
    }
}
