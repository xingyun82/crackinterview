package math;

/**
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 * Created by xingyun on 15/8/20.
 */
public class LC_13_RomanToInteger {

    public int romanToInt(String s) {
        int num = 0;
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) == 'M') {
                num += 1000;
            } else if (s.charAt(i) == 'D') {
                num += 500;
            } else if (s.charAt(i) == 'C') {
                if (i+1<s.length() && (s.charAt(i+1) == 'M' || s.charAt(i+1) == 'D')) {
                    num += -100;
                } else {
                    num += 100;
                }
            } else if(s.charAt(i) == 'L') {
                num += 50;
            } else if (s.charAt(i) == 'X') {
                if (i+1<s.length() && (s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L')) {
                    num += -10;
                } else {
                    num += 10;
                }
            } else if (s.charAt(i) == 'V') {
                num += 5;
            } else if (s.charAt(i) == 'I') {
                if (i+1<s.length() && (s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V')) {
                    num += -1;
                } else {
                    num += 1;
                }
            }
        }
        return num;
    }

}

