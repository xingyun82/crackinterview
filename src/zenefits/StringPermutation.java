package zenefits;

import java.util.*;

/**
 * given a permutation, give its lexicographical order
 *
 * 给一组String[](容量<10000)，求每一个String(长度<100)在其自己的
 Permutation Sequence中的序号

 Input: // String[]
 cab
 babc

 Output:  //返回 int[], index starting from 0
 4        //{abc, acb, bac, bca, 【cab】, cba}
 3        //{abbc, abcb, acbb, 【babc】,.....}

 //注意，String内有重复的Character，但 Permutation Sequence 只保留distinct记录

 * Created by xingyun on 15/8/28.
 */
public class StringPermutation {

    // main idea: backtracking
    // suppose str = cab
    // sort string to abc
    // compute how many permutations start from a,  b
    // k*(n-1)!
    // them permutationOrder(ab)
    /*
    public int permutationOrder(String str) {
        if(str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        // locate the first char
        int idx = 0;
        for(int i=0;i<chars.length; ++i) {
            if(str.charAt(0) == chars[i]) {idx = i; break;}
        }



    }

*/
}
