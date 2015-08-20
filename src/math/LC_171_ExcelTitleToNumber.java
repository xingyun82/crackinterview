package math;

/**
 * Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28


 * Created by xingyun on 15/6/4.
 */
public class LC_171_ExcelTitleToNumber {

    public int titleToNumber(String s) {
        int res = 0;
        for(int i=0;i<s.length();++i) {
            res = res*26 + (s.charAt(i)-'A'+1);
        }
        return res;
    }

    public static void main(String[] args) {
        LC_171_ExcelTitleToNumber inst = new LC_171_ExcelTitleToNumber();
        int res = inst.titleToNumber("AB");
        System.out.println(res);
    }

}
