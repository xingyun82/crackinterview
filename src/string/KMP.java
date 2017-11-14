package string;

import java.util.*;
/**
 * 实现KMP算法
 * 具体讲解：https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * Created by xingyun on 15/9/11.
 */
public class KMP {


    public int[] getPrefixArray(char[] B) {
        int[] P = new int[B.length];
        int j = 0;
        for(int i=1; i<B.length; ++i) {
            while(j>0 && B[j] != B[i]) j = P[j-1];
            if(B[j] == B[i]) j++;
            P[i] = j;
        }
        return P;
    }

    public List<Integer> match(char[] A, char[] B, int[] P) {
        List<Integer> res = new ArrayList<Integer>();
        int j = 0;
        for(int i=0; i<A.length; ++i) {
            while(j>0 && B[j] != A[i]) j = P[j-1];
            if(B[j] == A[i]) j++;
            if(j == B.length) {
                res.add(i-B.length+1);
                System.out.println("match at " + (i-B.length+1));
                j = P[j-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KMP inst = new KMP();
        char[] B = "ABCD".toCharArray();
        char[] A = "BBC ABCDAB ABCDABCDABDE".toCharArray();
        int[] P = inst.getPrefixArray(B);
        for(int i:P) {
            System.out.print(i+" ");
        }
        inst.match(A, B, P);
    }
}
