package hackerrank;

import java.io.*;
import java.util.*;

/**
 * 下一个顺序排列字符串
 * Created by xingyun on 15/8/29.
 */
public class BiggerIsGreater {


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

        private static String nextPermutation(String str) {
            String res = "no answer";
            char[] chs = str.toCharArray();
            int i = chs.length-2;
            for(; i>=0; --i) {
                if(chs[i] < chs[i+1]) break;
            }
            if(i==-1) return res;
            int j = chs.length-1;
            for(; j>i; --j) {
                if(chs[j] > chs[i]) break;
            }
            swap(chs, i, j);
            reverse(chs, i+1, chs.length-1);
            res = new String(chs);
            return res;
        }

        public static void main(String[] args) throws Exception {
            System.out.println(nextPermutation("zdhgfecba"));
            StringBuilder sb = new StringBuilder();
            String a = "";
            
        }
    }

