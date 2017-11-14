package array;

public class LC_441_ArrangeCoins {

    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }

    public int arrangeCoins2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            double r1 = 0.5*mid*(mid + 1);
            double r2 = 0.5*(mid+1)*(mid+2);
            if ( r1 <= n && n < r2) {
                return mid;
            } else if (r1 > n) {
                high = mid - 1;
            } else if (r2 <= n) {
                low = mid + 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        LC_441_ArrangeCoins inst = new LC_441_ArrangeCoins();
        System.out.println(inst.arrangeCoins(11020));
        System.out.println(inst.arrangeCoins2(11020));
    }
}
