package dp;

public class LC_664_StrangePrinter {

    public int strangePrinter(String s) {
        int n=s.length();
        int[][] f=new int[n][n];
        for (int i=n-1;i>=0;i--)
            for (int j=i;j<n;j++)
            {
                f[i][j]=(i==j)?1:1+f[i+1][j];
                for (int k=i+1;k<=j;k++)
                    if (s.charAt(k)==s.charAt(i)) f[i][j]=Math.min(f[i][j],f[i+1][k-1]+f[k][j]);
            }

        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j) {
                System.out.print(f[i][j] + ",");
            }
            System.out.println();
        }
        return (n==0?0:f[0][n-1]);
    }

    public static void main(String[] args) {
        LC_664_StrangePrinter inst = new LC_664_StrangePrinter();
        System.out.println(inst.strangePrinter("aba"));
    }
}
