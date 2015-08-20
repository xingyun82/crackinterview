package string;

/**
 *
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * Created by xingyun on 15/7/29.
 */

public class LC_65_ValidNumber {



    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDot(char c) {
        return c == '.';
    }

    private boolean isE(char c) {
        return c == 'e' || c == 'E';
    }

    /*
    public boolean isNumber(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0) return false;
        int i = 0;


        boolean nextMayDot = true;
        boolean nextMaySign = true;
        boolean nextMayE = false;

        boolean findDot = false;
        boolean findE = false;
        boolean findDigit = false;

        char c = s.charAt(0);
        while(i<len) {
            c = s.charAt(i);
            if(isSign(c)) {
                if(!nextMaySign) return false;
                nextMaySign = false;
                nextMayDot = !findE;
                nextMayE = false;
            } else if(isDot(c)) {
                if(!nextMayDot) return false;
                nextMaySign = false;
                nextMayDot = false;
                nextMayE = !findE && findDigit;
                findDot = true;
            } else if(isE(c)) {
                if(!nextMayE) return false;
                nextMaySign = true;
                nextMayDot = false;
                nextMayE = false;
                findE = true;
            } else if(isDigit(c)) {
                nextMaySign = false;
                nextMayDot = !findDot && !findE;
                nextMayE = !findE;
                findDigit = true;
            } else {
                return false;
            }
            i++;
        }
        if(!findDigit || isE(c) || isSign(c)) return false;
        return true;
    }

    */

    public boolean isNumber(String str) {
        int state = 0;
        boolean flag = false; // flag to judge the special case "."
        str = str.trim();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('0' <= c && c <= '9') {
                flag = true;
                if (state <= 2) state = 2;
                else state = (state <= 5) ? 5 : 7;
            } else if ('+' == c || '-' == c) {
                if (state == 0 || state == 3) state++;
                else return false;
            } else if ('.' == c) {
                if (state <= 2) state = 6;
                else return false;
            } else if ('e' == c) {
                if (flag && (state == 2 || state == 6 || state == 7)) state = 3;
                else return false;
            } else return false;
        }
        return (state == 2 || state == 5 || (flag && state == 6) || state == 7);
    }

    public static void main(String[] args) {
        LC_65_ValidNumber inst = new LC_65_ValidNumber();
        System.out.println(inst.isNumber("3.e1"));





    }
}
