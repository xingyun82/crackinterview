package mock;

/**
 * 来自之前百度一面的题目：给定一系列x轴的点坐标，例如 1，3，7，8，9，11这些坐标升序放在数组中，
 * 现在给一根绳子，长度为4，问绳子最多能覆盖的点数有多少，例如绳子放前面只能覆盖两个点，1,3，如果放后面能覆盖4个点。
 */
public class MaxCoverage {

    public int maxCoverage(int[] A, int K) {
        int i = 0, j=0;
        int max = 0;
        while(j<A.length) {
            while (j<A.length && A[j] - A[i] <= K) {
                j++;
            }
            max = Math.max(j - i, max);
            while (j<A.length && A[j] - A[i] >= K) {
                i++;
            }
        }
        return max;
    }

    public int maxCoverage2(int[] A, int K) {
        int i = 0, j=0;
        int max = 0;
        while(j<A.length) {
            while (j<A.length && A[j] - A[i] > K) {
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 7, 8, 9, 11};
        int K = 4;
        MaxCoverage inst = new MaxCoverage();
        System.out.println(inst.maxCoverage2(A, K));
    }
}
