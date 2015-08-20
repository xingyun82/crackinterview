package math;


import java.util.*;
/**
 *
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.

 * Created by xingyun on 15/8/20.
 */
public class LC_43_MultiplyStrings {

    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        List<Integer> intRes = new ArrayList<Integer>(Collections.nCopies(num1.length()+num2.length(), 0));
        for (int i=num1.length()-1;i>=0;i--) {
            for (int j=num2.length()-1;j>=0;j--) {
                int idx = num1.length()-1-i+num2.length()-1-j;
                int mult = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+intRes.get(idx);
                intRes.set(idx, mult%10);
                intRes.set(idx+1, intRes.get(idx+1)+mult/10);
            }
        }
        int start = intRes.size()-1;
        while (start>=0 && intRes.get(start) == 0) {
            start--;
        }
        if (start==-1) return "0";
        while (start >= 0) {
            res.append(intRes.get(start));
            start--;
        }
        return res.toString();
    }

}
