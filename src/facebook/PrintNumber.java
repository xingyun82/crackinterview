package facebook;

/**
 * Created by xingyun on 15/8/28.
 */
public class PrintNumber {

    public static String[] lessThanTwenty =  new String[]{
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "ninteen"
    };
    public static String[] largerThanTwenty = new String[] {
            "none",
            "ten",
            "twenty",
            "thirty",
            "fourty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninty"
    };

    public String getLessthanThousand(int num) {
        String res = "";
        int h = num/100;
        int t = (num-h*100)/10;
        int s = (num-h*100-t*10)%10;
        if(h>0) res += lessThanTwenty[h] + " hundred";
        if(h>0 && (t >0 || s > 0)) res += " and ";
        if(t>=2) {
            res += largerThanTwenty[t];
            if(s>0) res+= " " + lessThanTwenty[s];
        } else {
            res += lessThanTwenty[num-h*100];
        }
        return res;
    }

    public String printInteger(int num) {
        String res = "";
        int i=0;
        while(num > 0) {
            String seg = getLessthanThousand(num%1000);
            if(i==0) {
                res += seg;
            } else if(i == 1) {
                res = seg + " thousand " + res;
            } else if(i == 2) {
                res = seg + " million " + res;
            } else if(i == 3) {
                res = seg + " billioin " + res;
            }
            i++;
            num = num/1000;
        }
        return res;
    }

    public static void main(String[] args) {
        PrintNumber inst = new PrintNumber();
        System.out.println(inst.printInteger(1013));
    }

}
