package array;


import java.util.*;

class Pair {

    public int first;
    public int second;
    public Pair(int i, int j) {first = i; second = j;}
}
/**
 * Created by xingyun on 15/9/1.
 */
public class SellStockIV {

    public int maxProfit(int k, int[] a) {
        if(a == null || a.length < 2 || k<= 0) return 0;
        int n = a.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        Stack<Pair> vps = new Stack<Pair>();
        int v = 0, p =0;
        while(p<n) {
            for(v=p; v<n-1 && a[v]>=a[v+1]; v++);
            for(p=v+1; p<n && a[p]>=a[p-1]; p++);

            while(!vps.isEmpty() && a[vps.peek().first] > a[v]) {
                pq.offer(a[vps.peek().second-1]-a[vps.peek().first]);
                vps.pop();
            }
            while(!vps.isEmpty() && a[p-1] >= a[vps.peek().second-1]) {
                pq.offer(a[vps.peek().second-1] - a[v]);
                v = vps.peek().first;
                vps.pop();
            }
            vps.push(new Pair(v, p));
        }
        //
        while(!vps.isEmpty()) {
            pq.offer(a[vps.peek().second-1] - a[vps.peek().first]);
            vps.pop();
        }
        // pop out the k largest value, and sum up
        int maxProfit = 0;

        for(int i=0; i<k && !pq.isEmpty(); ++i) {
            maxProfit += pq.poll();
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 4, 5, 2, 9, 7};
        SellStockIV inst = new SellStockIV();
        System.out.println(inst.maxProfit(2, a));

    }
}
