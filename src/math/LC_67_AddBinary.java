package math;

/**
 *
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 * Created by xingyun on 15/8/20.
 */
public class LC_67_AddBinary {

    public String addBinary(String a, String b) {

        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        int alen = a.length();
        int blen = b.length();
        int len = Math.max(alen, blen)+1;
        // chars to store new sum
        char[] chars = new char[len];
        int i = alen-1, j = blen-1, k = len-1;
        int carry = 0;
        while(i>=0&&j>=0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            chars[k--] = (char)(sum%2 + '0');
            carry = sum/2;
            i--;
            j--;
        }
        while(i>=0) {
            int sum = a.charAt(i) - '0' + carry;
            chars[k--] = (char)(sum%2 + '0');
            carry = sum/2;
            i--;
        }
        while(j>=0) {
            int sum = b.charAt(j) - '0' + carry;
            chars[k--] = (char)(sum%2 + '0');
            carry = sum/2;
            j--;
        }
        chars[0] = (char)(carry + '0');
        if(carry == 1) return new String(chars);
        StringBuffer sb = new StringBuffer();
        for(i=1; i<chars.length; ++i) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}
