package hackerrank;

import java.util.*;
/**
 * Created by xingyun on 15/8/25.
 */
public class GridSearch {

    public static boolean isEqual(String[] matrix1, int i1, int j1, String[] matrix2, int i2, int j2, int m, int n) {
        if(i1+m > matrix1.length) return false;
        if(j1+n > matrix1[0].length()) return false;
        for(int i=0; i<m; ++i) {
            String str1 = matrix1[i1+i].substring(j1, j1+n);
            String str2 = matrix2[i2+i].substring(j2, j2+n);
            if(!str1.equals(str2)) return false;
        }
        return true;
    }

    public static boolean isContains(String[] matrix1, String[] matrix2) {
        int m = matrix1.length;
        int n = matrix1[0].length();
        int p = matrix2.length;
        int q = matrix2[0].length();
        if(m<p || n <q) return false;
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(matrix1[i].charAt(j) == matrix2[0].charAt(0)) {
                    if(isEqual(matrix1, i, j, matrix2, 0, 0, p, q)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for(int i=0; i<N; ++i) {
            int m = s.nextInt();
            int n = s.nextInt();
            s.nextLine();
            String[] matrix1 = new String[m];
            for(int j=0; j<m; ++j) {
                matrix1[j] = s.nextLine();
            }
            int p = s.nextInt();
            int q = s.nextInt();
            s.nextLine();
            String[] matrix2 = new String[p];
            for(int j=0; j<p; ++j) {
                matrix2[j] = s.nextLine();
            }
            if(isContains(matrix1, matrix2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
