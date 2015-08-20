package math;

/**
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 * Created by xingyun on 15/7/26.
 */
public class LC_60_PermutationSequence {


    public void getPermutation2(StringBuilder str, int k, int fixed) {
        if(k==1) return;
        int len = str.length();
        int m = 1;
        int n = 1;
        int pren = 1;
        while(m<=len-fixed) {
            pren = n;
            n *= m;
            if(n>=k) break;
            m++;
        }
        int p = (k-1)/pren;
        char i = str.charAt(len-m);
        char j = str.charAt(len-m+p);
        str.setCharAt(len-m, j);
        str.deleteCharAt(len - m + p);
        str.insert(len-m+1, i);
        getPermutation2(str, k-p*pren, len-m+1);
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; ++i) {
            sb.append(i);
        }
        getPermutation2(sb, k, 0);
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_60_PermutationSequence inst = new LC_60_PermutationSequence();

        //System.out.println(inst.getPermutation(5, 10));
        StringBuilder str = new StringBuilder("abcde");
        inst.getPermutation2(str, 10, 0);
        System.out.println(str);

    }
}
