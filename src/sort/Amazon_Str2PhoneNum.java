package sort;

import java.util.*;
/**
 *
 You are given a phone keypad like following diagram, where each character corresponds to a digit mentioned in the same box.


 phoneKeyboard

 You are given n strings and you have to find their decimal representation.
 You have to print the string and corresponding decimal representation in descending order.
 For example, if you are given “amazon” then its corresponding decimal notation will be 262966.
 If more than one strings have same decimal notation then you have to print them in the order
 in which input is given. The given string consists of lower case alphabets only.

 Test Case 1:
 5
 Amazon
 Microsoft
 Facebook
 Aa
 Bb

 Output:
 642767638  microsoft
 32232665  facebook
 262966  amazon
 22 aa
 22 bb

 * Created by xingyun on 15/9/9.
 */



public class Amazon_Str2PhoneNum {

    class StrNum {
        public String str;
        public String num;
        public StrNum(String str, String num) {this.str = str; this.num = num;}
        public int compareTo(StrNum o) {
            return num.compareTo(o.num);
        }
    }


    public final static int[] chmap = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};

    public  StrNum str2StrNum(String str) {
        StringBuilder sb = new StringBuilder();
        str = str.toLowerCase();
        for(int i=0; i<str.length(); ++i) {
            sb.append(chmap[str.charAt(i)-'a']);
        }
        StrNum sn = new StrNum(str, sb.toString());
        return sn;
    }

    public  void mergeSort(StrNum[] strnums, int i, int j) {
        if(i==j) return;
        int mid = (i+j)>>1;
        mergeSort(strnums, i, mid);
        mergeSort(strnums, mid+1, j);
        StrNum[] res = new StrNum[j-i+1];
        int s1 = i, s2 = mid+1, s3=0;
        while(s1 <= mid && s2 <= j) {
            if(strnums[s1].compareTo(strnums[s2]) >= 0) {
                res[s3++] = strnums[s1++];
            } else {
                res[s3++] = strnums[s2++];
            }
        }
        while(s1 <= mid) {
            res[s3++] = strnums[s1++];
        }
        while(s2 <= j) {
            res[s3++] = strnums[s2++];
        }
        s3 = 0;
        for(int k=i; k<=j; ++k) {
            strnums[k] = res[s3++];
        }
    }



    public static void main(String[] args) {
        Amazon_Str2PhoneNum inst = new Amazon_Str2PhoneNum();
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        StrNum[] strnums = new StrNum[N];
        for(int i=0; i<N; ++i) {
            String str = sc.next();
            StrNum sn = inst.str2StrNum(str);
            strnums[i] = sn;
        }
        inst.mergeSort(strnums, 0, N - 1);
        for(int i=0; i<N; ++i) {
            System.out.println(strnums[i].num + " " + strnums[i].str);
        }
        
    }
}
