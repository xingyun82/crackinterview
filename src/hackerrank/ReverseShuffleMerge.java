package hackerrank;

import java.util.*;
import java.io.*;
/**
 * Created by xingyun on 15/8/30.
 */
public class ReverseShuffleMerge {

    private static String smallestPermutation = null;
    /*
    main idea:
    1. get all reverse permutation, find the lexicographically smallest
    */
    /*
    private static void getReversePermutation(String str, int[] chmap, int[] inmap, int[] outmap, int cur, StringBuilder sb) {
        if(cur < 0) return;
        char c = str.charAt(cur);
        int total = chmap[c-'a'];
        int in = inmap[c-'a'];
        int out = inmap[c-'a'];

        if(in > total/2 || out > total/2) return;
        if(sb.length() == str.length()/2) {

            String permutation = sb.toString();
            //System.err.println(permutation);
            if(smallestPermutation == null) smallestPermutation = permutation;
            else if(permutation.compareTo(smallestPermutation) < 0) {
                smallestPermutation = permutation;
            }
            return;
        }


        // use this char
        inmap[c-'a']++;
        sb.append(c);
        getReversePermutation(str, chmap, inmap, outmap, cur-1, sb);
        // ignore this char
        inmap[c-'a']--;
        sb.deleteCharAt(sb.length()-1);

        outmap[c-'a']++;
        getReversePermutation(str, chmap, inmap, outmap, cur-1, sb);

    }

    private static void getSmallestPermutation(String str) {
        int[] chmap = new int[26];
        for(int i=0; i<str.length(); ++i) {
            chmap[str.charAt(i)-'a']++;
        }
        int[] inmap = new int[26];
        int[] outmap = new int[26];
        StringBuilder sb = new StringBuilder();
        getReversePermutation(str, chmap, inmap, outmap, str.length()-1, sb);
    }*/

    private static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    private static void reverse(char[] chs, int i, int j) {
        while(i<j) {
            swap(chs, i, j);
            i++;
            j--;
        }
    }

    private static boolean isPermutation(char[] chs, int[] chfm, StringBuilder sb, int cur) {
        if(sb.length() == chs.length/2) {
            smallestPermutation = sb.toString();
            //System.err.println(smallestPermutation);
            return true;
        }
        if(cur >= chs.length) return false;
        // choose next step
        for(int i=0; i<chfm.length; ++i) {
            if(chfm[i] == 0) continue;
            char c = (char)(i+'a');
            // find next cur
            int j = cur;
            for(; j<chs.length; ++j) {
                if(chs[j] == c) break;
            }
            if(j == chs.length) return false;

            // next step
            chfm[i]--;
            sb.append(c);
            System.err.println("c:" + c + ",cur:" + cur +  ",j:" + j +  ",tmp:" + sb);
            if(isPermutation(chs, chfm, sb, j+1)) return true;
            // backtrack
            chfm[i]++;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }

    private static void getSmallestPermutation(String str) {
        char[] chs = str.toCharArray();
        reverse(chs, 0, chs.length-1);
        System.err.println("reversed:" + new String(chs));
        int[] chfm = new int[26];
        for(char c:chs) {
            chfm[c-'a']++;
        }
        for(int i=0; i<26; ++i) {
            chfm[i] /= 2;
            //char c = (char)(i+'a');
            //System.err.println(c + ":" + chfm[i]);
        }
        StringBuilder sb = new StringBuilder();
        isPermutation(chs, chfm, sb, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        getSmallestPermutation(str);
        System.out.println(smallestPermutation);

    }
}
