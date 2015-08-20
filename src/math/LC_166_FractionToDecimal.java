package math;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".


 * Created by xingyun on 15/6/4.
 */
public class LC_166_FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();
        if((numerator>0&&denominator<0) || (numerator<0&&denominator>0)) {
            sb.append("-");
        }
        long numerator2 = Math.abs((long)numerator);
        long denominator2 = Math.abs((long)denominator);

        long intPart = numerator2/denominator2;
        long remain = numerator2%denominator2;

        sb.append(intPart);
        if(remain == 0) return sb.toString();
        sb.append(".");

        HashMap<Long, String> remainFractMap = new HashMap<Long, String>();
        List<Long> remainKeys = new ArrayList<Long>();

        boolean repeatFlag = false;
        long repeatRemain = -1;

        while(remain != 0) {
            StringBuffer rmSb = new StringBuffer();
            long oriRemain = remain;
            remain = remain*10;

            intPart = remain / denominator2;
            rmSb.append(intPart);
            remain = remain % denominator2;

            if(!remainFractMap.containsKey(oriRemain)) {
                remainFractMap.put(oriRemain, rmSb.toString());
                remainKeys.add(oriRemain);
            }
            if(remain == 0) {
                //    sb.append(rmSb);
                break;
            }
            if(remainFractMap.containsKey(remain)) {
                repeatFlag = true;
                repeatRemain = remain;
                break;
            }
        }
        if(!repeatFlag) {
            for(Long rKey:remainKeys) {
                sb.append(remainFractMap.get(rKey));
            }
        } else {
            for(Long rKey:remainKeys) {
                if(rKey==repeatRemain) {
                    sb.append("(");
                }
                sb.append(remainFractMap.get(rKey));
            }
            if(repeatFlag) {
                sb.append(")");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args){
        LC_166_FractionToDecimal inst = new LC_166_FractionToDecimal();
        System.out.println(inst.fractionToDecimal(10, 2));
    }
}
