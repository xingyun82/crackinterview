package math;

/**
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 * Created by xingyun on 15/8/19.
 */
public class LC_66_PlusOne {


    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        int len = digits.length;
        // newDigits is to store numbers after plus one
        int[] newDigits = new int[len+1];
        int carry = 1;
        for(int i=len-1; i>=0; i--) {
            newDigits[i+1] = (digits[i]+carry)%10;
            carry = (digits[i]+carry)/10;
        }
        newDigits[0] = carry;
        if(newDigits[0] == 1) return newDigits;
        // remove the head zero
        int[] res = new int[len];
        for(int i=0;i<len; ++i) {
            res[i] = newDigits[i+1];
        }
        return res;
    }
}
