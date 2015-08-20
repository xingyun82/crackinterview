package math;

/**
 * Created by xingyun on 15/6/29.
 */
public class LC_134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int delta = 0;
        int start = 0;
        int i = 0;
        while(i-start<n && start<n) {
            delta += gas[i%n] - cost[i%n];
            if(delta < 0) {
                start = i+1;
                delta = 0;
            }
            i++;
        }
        if(start>=n) return -1;
        if(delta>=0) return start%n;
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{4};
        int[] cost = new int[]{5};
        LC_134_GasStation inst = new LC_134_GasStation();
        System.out.println(inst.canCompleteCircuit(gas, cost));
    }
}
