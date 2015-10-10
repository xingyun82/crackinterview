package amazon;

/**
 *
 * 有一种String,是把一个更短的String重复n次而构成的，那个更短的String长度至少为
 2，输入一个String写代码返回T或者F
 例子：
 "abcabcabc"  Ture   因为它把abc重复3次构成
 "bcdbcdbcde" False  最后一个是bcde
 "abcdabcd"   True   因为它是abcd重复2次构成
 "xyz"       False  因为它不是某一个String重复
 "aaaaaaaaaa"  False  重复的短String长度应至少为2（这里不能看做aa重复5次)

 要求算法复杂度为O(n)

 public boolean isMultiple(String s){

 }

 Source: http://www.mitbbs.com/article_t/JobHunting/32633319.html

 * Created by xingyun on 15/8/21.
 */
public class RepeatedStr {

    // idea: KMP algorithm
    public int[] getPositions(char[] A) {
        int n = A.length;
        int[] P = new int[n];
        int j=0;
        for(int i=1; i<n; ++i) {
            while(j>0&&A[i]!=A[j]) j=P[j-1];
            if(A[i] == A[j]) j++;
            P[i] = j;
        }
        return P;
    }

    public boolean isMultiple(String s) {
        int[] P = getPositions(s.toCharArray());
//        for(int i:P) {
//            System.out.print(i + " ");
//        }
        int maxP = P[s.length()-1];
        int delta = s.length() - maxP;
        int i = s.length()-1;

        if(i+1 == delta*2 && delta != 1) return true;
        while(i>=0 && P[i] == i+1 - delta) {
            i -= delta;
            if(i+1 == delta*2 && delta != 1) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        RepeatedStr inst = new RepeatedStr();
        System.out.println(inst.isMultiple("a"));
    }
}
