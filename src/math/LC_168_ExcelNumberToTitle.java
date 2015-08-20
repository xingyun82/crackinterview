package math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB


 * Created by xingyun on 15/6/4.
 */
public class LC_168_ExcelNumberToTitle {


    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n!=0) {
            n -= 1;
            sb.insert(0, (char)('A'+n%26));
            n /= 26;
        }
        return sb.toString();
    }

    /*
    public String convertToTitle(int n) {
        String res = "";
        while(n!=0) {
            int remain = n%26;
            if(remain == 0) {
                res = 'Z' + res;
                n = n-26;
            } else {
                char c = (char) ('A' + remain -1);
                res = c + res;
            }
            n = n / 26;
        }
        return res;
    }
    */


    public static void main(String[] args) {
        LC_168_ExcelNumberToTitle inst = new LC_168_ExcelNumberToTitle();
        System.out.println(inst.convertToTitle(52));
    }
}
