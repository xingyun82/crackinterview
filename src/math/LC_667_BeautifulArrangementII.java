package math;

public class LC_667_BeautifulArrangementII {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i=0; i<=k; i=i+2) {
            result[i] = (i+2)/2;
        }
        for (int i=1; i<=k; i=i+2) {
            result[i] = k+2 - (i+1)/2;
        }
        for (int i=k+1; i<n; ++i) {
            result[i] = i+1;
        }
        return result;
    }

    public static void main(String[] args) {
        LC_667_BeautifulArrangementII inst = new LC_667_BeautifulArrangementII();
        for ( int i: inst.constructArray(10, 7)) {
            System.out.print(i + ",");
        }
    }
}
