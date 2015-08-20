package math;

/**
 *
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * Created by xingyun on 15/2/7.
 */
public class LC_8_Atoi {

    public int atoi(String s) {
        int res = 0;
        if (s == null || s.isEmpty()) return 0;
        s = s.trim();
        boolean isLessThan0 = false;
        int maxDivide10 = Integer.MAX_VALUE/10;
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if (i == 0 && !((c>='0' && c<='9')|| c=='+' || c=='-')) {
                return 0;
            }
            if (i != 0 && !(c>='0' && c<='9')) {
                break;
            }
            if (c=='+') continue;
            if (c=='-') { isLessThan0 = true; continue;}
            if (res > maxDivide10) { return isLessThan0?Integer.MIN_VALUE:Integer.MAX_VALUE; }
            res = res*10;
            if (res > Integer.MAX_VALUE - (c-'0')) { return isLessThan0?Integer.MIN_VALUE:Integer.MAX_VALUE; }
            res += (c-'0');
        }
        if (isLessThan0) res = -res;
        return res;
    }

    public static void main(String[] args) {
        //注意边界条件
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(214748369*10 > Integer.MAX_VALUE);
        LC_8_Atoi inst = new LC_8_Atoi();
        System.out.println(inst.atoi("aaga"));
        System.out.println(inst.atoi(null));
        System.out.println(inst.atoi(""));
        System.out.println(inst.atoi("+123"));
        System.out.println(inst.atoi("-123"));
        System.out.println(inst.atoi("12aa1"));
        System.out.println(inst.atoi("1234567890123422"));
        System.out.println(inst.atoi("-1234567890123422"));
    }

}
