package geeksforgeeks;

/**
 * Created by xingyun on 15/9/4.
 */
public class MaxSubseqSumNoNextEachOther {

    public int maxSubseqSum(int[] a) {
        if(a == null || a.length == 0) return 0;
        int incl = a[0], excl = 0;
        int max = 0;
        for(int i=1; i<a.length; ++i) {
            max = Math.max(incl, excl);
            incl = excl + a[i];
            excl = max;
        }
        return Math.max(incl, excl);
    }
}
