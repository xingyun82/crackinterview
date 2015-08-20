package sort;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.


 *
 * Created by xingyun on 15/6/3.
 */
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class StrNum implements Comparable{

    public int num;

    public StrNum(int n) {
        num = n;
    }

    @Override
    public int compareTo(Object obj) {
        if(!(obj instanceof StrNum)) return 0;
        int num2 = ((StrNum) obj).num;
        String numStr = String.valueOf(num);
        String numStr2 = String.valueOf(num2);
        int i=0;
        while(i<numStr.length() && i<numStr2.length()) {
            if(numStr.charAt(i) > numStr2.charAt(i)) return 1;
            if(numStr.charAt(i) < numStr2.charAt(i)) return -1;
            i++;
        }

        if(i==numStr.length()) {
            char c = numStr.charAt(0);
            char c2 = numStr.charAt(i-1);
            while(i<numStr2.length() && c == numStr2.charAt(i)) {
                i++;
            }
            if (i == numStr2.length())
            {
                return c2 - numStr2.charAt(i-1);
            }
            if (c > numStr2.charAt(i)) return 1;
            if (c < numStr2.charAt(i)) return -1;
        }


        if(i==numStr2.length()) {
            char c = numStr2.charAt(0);
            char c2 = numStr2.charAt(i-1);
            while(i<numStr.length() && c == numStr.charAt(i)) {
                i++;
            }
            if (i == numStr.length()) {
                return numStr.charAt(i-1)-c2;
            }
            if (c > numStr.charAt(i)) return -1;
            if (c < numStr.charAt(i)) return 1;
        }
        return 0;
    }
}


public class LC_179_LargestNumber {



    public String largestNumber(int[] nums) {
        String res = "";
        int zeroCount = 0;
        List<StrNum> strNums = new ArrayList<StrNum>();
        for(int num : nums) {
            if(num == 0) zeroCount++;
            StrNum strNum = new StrNum(num);
            strNums.add(strNum);
        }
        if (zeroCount == nums.length) return "0";
        Collections.sort(strNums);
        for(int i=strNums.size()-1;i>=0;i--) {
            res += strNums.get(i).num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};

        LC_179_LargestNumber inst = new LC_179_LargestNumber();
        String res = inst.largestNumber(nums);
        System.out.println(res);


        {
            StrNum strNum1 = new StrNum(30);
            StrNum strNum2 = new StrNum(4);
            System.out.println(strNum1.compareTo(strNum2));
        }
        {
            StrNum strNum1 = new StrNum(824);
            StrNum strNum2 = new StrNum(8247);
            System.out.println(strNum1.compareTo(strNum2));
        }
        {
            StrNum strNum1 = new StrNum(3);
            StrNum strNum2 = new StrNum(30);
            System.out.println(strNum1.compareTo(strNum2));
        }
        {
            StrNum strNum1 = new StrNum(30);
            StrNum strNum2 = new StrNum(31);
            System.out.println(strNum1.compareTo(strNum2));
        }
        {
            StrNum strNum1 = new StrNum(3);
            StrNum strNum2 = new StrNum(332);
            System.out.println(strNum1.compareTo(strNum2));
        }
        {
            StrNum strNum1 = new StrNum(10);
            StrNum strNum2 = new StrNum(101);
            System.out.println(strNum1.compareTo(strNum2));
        }

    }
}
