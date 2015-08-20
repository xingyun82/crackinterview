package trulia;

/**
 * Created by xingyun on 15/7/23.
 */
public class Equilibrium {

    public int equilibrium(int[] A) {
        if(A == null || A.length == 0) return -1;
        long sum =0;
        for(int i:A) sum+=i;
        // if i+1 is equilibrium
        long tmpSum = 0;
        // a1, a2, a3,  ...ai-1,  ai, ai+1, .. an
        // suppose tmpsum = sum(a1,.. ai-1),
        // if ai is equilibrium, then tmpsum = sum(ai+1, ... an)
        // so, tmpsum == sum - ai - tmpsum
        for(int i=0;i<A.length; ++i) {
            if(tmpSum == sum - A[i] - tmpSum) return i;
            tmpSum += A[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,-1,4, -1};

        Equilibrium inst = new Equilibrium();
        System.out.println(inst.equilibrium(A));
        StringBuilder sb = new StringBuilder();

    }
}
