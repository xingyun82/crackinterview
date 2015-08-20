package geeksforgeeks;

import java.util.*;
/**
 *
 * Created by xingyun on 15/8/15.
 */
public class CombinationN {

    public void backtrack(List<Integer> comb, int n, boolean flag) {
        if(n == 0) {
            for(int i:comb) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        if(flag) {
            for(int i=n;i>=1;--i) {
                comb.add(i);
                backtrack(comb, n-i, true);
                comb.remove(comb.size()-1);
            }
        } else {
            for(int i=n-1; i>=1; --i) {
                comb.add(i);
                backtrack(comb, n-i, true);
                comb.remove(comb.size()-1);
            }
        }
    }
    public void printCombination(int n) {
        List<Integer> comb = new ArrayList<Integer>();
        backtrack(comb, n, false);
    }

    public static void main(String[] args) {
        CombinationN inst = new CombinationN();
        inst.printCombination(3);
    }
}
