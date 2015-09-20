package string;

/**
 *
 * You have two strings A and B. Each one contains some letters and exactly one asterisk.

 You have to replace the asterisk in each string with a letter sequence (possibly of zero length) so that the resulting two

 strings are equal. This equal string is what you have to return. Attempt to return the shortest possible string.

 The letter sequences may be same or different.

 If it is not possible to make the given strings equal, return the string "not-possible".

 Additional Constraints

 - A and B will contain only uppercase letters and asterisks.

 - A and B will contain one asterisk each.

 Examples

 0)

 "SOCIA*TWIST"

 "SOCIALTWI*T"

 Returns: "SOCIALTWIST"

 1)

 "HELLO*"

 "HI*"

 Returns: "not-possible"

 * Created by xingyun on 9/19/15.
 */
public class A9_MergeTwoWildCardStrs {

    public int sufEqualsPre(String str1, String str2) {
        int maxk = Math.min(str1.length(), str2.length());
        for(int k=maxk; k>=1; k--) {
            if(str1.substring(str1.length()-k).equals(str2.substring(0, k))) return k;
        }
        return 0;
    }

    public String merge(String str1, String str2) {
        String res = "not-possible";
        int i = str1.indexOf('*');
        int j = str2.indexOf('*');
        if(i<j) {
            return merge(str2, str1);
        }
        for(int k=0; k<j; ++k) {
            if(str1.charAt(k) != str2.charAt(k)) return res;
        }
        int e1 = str1.length()-1;
        int e2 = str2.length()-1;
        while(e1 > i && e2 > j) {
            if(str1.charAt(e1) != str2.charAt(e2)) return res;
            e1--; e2--;
        }

        String seg1 = str1.substring(j, i);
        String seg2 = str2.substring(j + 1, e2 + 1);
        int sufpre = sufEqualsPre(seg1, seg2);
        String merge = seg1 + seg2.substring(sufpre);
        res = str2.substring(0, j) + merge + (e1 == i?str1.substring(e1+1):str1.substring(e1));
        return res;
    }

    public static void main(String[] args) {
        String str1 = "SOCIA*TWIST";
        String str2 = "SOCIALTWI*T";
        A9_MergeTwoWildCardStrs inst = new A9_MergeTwoWildCardStrs();
        System.out.println(inst.merge(str1, str2));
    }
}
