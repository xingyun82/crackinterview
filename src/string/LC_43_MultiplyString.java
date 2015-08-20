package string; /**
 * Created by xingyun on 15/3/8.
 */
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LC_43_MultiplyString {

    /*
        public void addList(List<Integer> res, List<Integer> num) {
        int carry = 0;
        int i = 0;
        while(i<num.size()&&i<res.size()) {
            int sum = res.get(i)+num.get(i)+carry;
            res.set(i, sum%10);
            carry = sum/10;
            i++;
        }
        while (i<num.size()) {
            int sum = num.get(i) + carry;
            res.add(sum%10);
            carry = sum/10;
            i++;
        }
        while (i<res.size()) {
            int sum = res.get(i) + carry;
            res.add(sum%10);
            carry = sum/10;
            i++;
        }
        if (carry>0) {
            res.add(carry);
        }
    }


    public String multiply(String num1, String num2) {
        StringBuilder strBuilder = new StringBuilder();
        List<Integer> res = new ArrayList<Integer>();
        for (int i=num1.length()-1; i>=0; --i) {
            List<Integer> multiply = new ArrayList<Integer>();
            for (int k=i; k<num1.length()-1; ++k) {
                multiply.add(0);
            }
            int lastCarry = 0;
            for (int j=num2.length()-1; j>=0; --j) {
                int mul = (num1.charAt(i)-'0')* (num2.charAt(j)-'0');
                multiply.add((mul+lastCarry)%10);
                lastCarry = (mul+lastCarry)/10;
            }
            if (lastCarry != 0) {
                multiply.add(lastCarry);
            }
            if (multiply.get(multiply.size()-1) == 0) {
                multiply = new ArrayList<Integer>();
                multiply.add(0);
            }

            addList(res, multiply);
        }
        for (int i=res.size()-1;i>=0;--i) {
            strBuilder.append(res.get(i));
        }
        return strBuilder.toString();
    }
     */

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
        if (start == -1) return "0";
        while (start >= 0) {
            res.append(intRes.get(start));
            start--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "1";
        LC_43_MultiplyString inst = new LC_43_MultiplyString();
        System.out.println(inst.multiply(num1, num2));

    }
}
