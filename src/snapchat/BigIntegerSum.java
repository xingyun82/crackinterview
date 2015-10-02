package snapchat;

/**
 *
 * 大数加、减法
 * 1. 先不考虑符号，写出基本的大数、加减法算法
 * 2. 在wrapper方法里考虑字符串是否有效、符号等问题，然后调用基本的算法
 * 3. 减法 先不考虑结果左边多余的0，到最后翻转前去掉那些0
 *
 * Created by xingyun on 9/30/15.
 */
public class BigIntegerSum {

    public boolean validInteger(String str) {
        if(str == null || str.length() == 0) return false;
        int sign = 1;
        int cursor = 0;
        if(str.charAt(0) == '+') {
            sign = 1;
            cursor++;
        } else if(str.charAt(0) == '-') {
            sign = -1;
            cursor++;
        }
        if(cursor == str.length()) return false;
        while(cursor < str.length() && str.charAt(cursor) >= '0' && str.charAt(cursor) <= '9') {
            cursor++;
        }
        return cursor == str.length();
    }


    public String sum(String num1, String num2) {
        if(!validInteger(num1) || !validInteger(num2)) return "exception!";
        int s1 = 1, s2 = 1;
        int sidx1 = 0, sidx2 = 0;
        if(num1.charAt(0) == '+') { s1 =1; sidx1 = 1; }
        else if(num1.charAt(0) == '-') { s1=-1; sidx1 =1; }
        if(num2.charAt(0) == '+') { s2 = 1; sidx2 = 1; }
        else if(num2.charAt(0) == '-') { s2 =-1; sidx2 = 1; };

        if(s1>0 && s2>0) return doSum(num1.substring(sidx1), num2.substring(sidx2));
        else if(s1>0 && s2<0) return doAbstract(num1.substring(sidx1), num2.substring(sidx2));
        else if(s1<0 && s2>0) return doAbstract(num2.substring(sidx2), num1.substring(sidx1));
        else if(s1<0 && s2<0) return "-" + doSum(num1.substring(sidx1), num2.substring(sidx2));

        return "exception!";
    }

    public String doSum(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        int tmp = 0;
        while(i>=0 && j>=0) {
            tmp = (num1.charAt(i)-'0' + num2.charAt(j)-'0' + carry);
            carry = tmp/10;
            sb.append(tmp%10);
            i--;
            j--;
        }
        while(i>=0) {
            tmp = (num1.charAt(i)-'0'+carry);
            carry = tmp/10;
            sb.append(tmp%10);
            i--;
        }
        while(j>=0) {
            tmp = (num2.charAt(j) - '0' + carry);
            carry = tmp/10;
            sb.append(tmp%10);
            j--;
        }
        if(carry > 0) sb.append(carry);

        return sb.reverse().toString();

    }

    public String doAbstract(String num1, String num2) {

        if(num1.length() < num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) < 0)) {
            return "-" + doAbstract(num2, num1);
        }


        StringBuilder sb = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        int tmp = 0;
        while(i>=0 && j>=0) {
            tmp = num1.charAt(i) + carry - num2.charAt(j);
            if(tmp>=0) {
                sb.append(tmp);
                carry = 0;
            } else {
                sb.append(tmp+10);
                carry = -1;
            }
            i--;
            j--;
        }
        while(i>=0) {
            tmp = num1.charAt(i) - '0' + carry;
            if(tmp >= 0) {
                sb.append(tmp);
                carry = 0;
            } else{
                sb.append(tmp+10);
                carry = -1;
            }
            i--;
        }
        while(sb.length()>1 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }
        if(carry < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "10";
        String num2 = "-111";
        BigIntegerSum inst = new BigIntegerSum();
        System.out.println(inst.sum(num1, num2));
    }
}
