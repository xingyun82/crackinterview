package math;

/**
 *
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.

 * Created by xingyun on 15/8/20.
 */
public class LC_12_IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        if (num >= 4000) return "unknown";
        int ms = num / 1000;
        for (int i = 0; i < ms; ++i) {
            res.append("M");
        }
        int cs = (num - ms * 1000) / 100;
        if (cs == 9) {
            res.append("CM");
        } else if (cs >= 5) {
            res.append("D");
            for (int i = 5; i < cs; ++i) {
                res.append("C");
            }
        } else if (cs == 4) {
            res.append("CD");
        } else {
            for (int i = 0; i < cs; ++i) {
                res.append("C");
            }
        }
        int xs = (num - ms * 1000 - cs * 100) / 10;
        if (xs == 9) {
            res.append("XC");
        } else if (xs >= 5) {
            res.append("L");
            for (int i = 5; i < xs; ++i) {
                res.append("X");
            }
        } else if (xs == 4) {
            res.append("XL");
        } else {
            for (int i = 0; i < xs; ++i) {
                res.append("X");
            }
        }
        int is = num % 10;
        if (is == 9) {
            res.append("IX");
        } else if (is >= 5) {
            res.append("V");
            for (int i = 5; i < is; ++i) {
                res.append("I");
            }
        } else if (is == 4) {
            res.append("IV");
        } else {
            for (int i = 0; i < is; ++i) {
                res.append("I");
            }
        }
        return res.toString();
    }
}
