package string;

/**
 * Created by xingyun on 15/9/7.
 */


public class A9_ReverseStrByWords {

    public void reverseWord(StringBuilder str, int s, int e) {
        while(s<e) {
            char tmp = str.charAt(s);
            str.setCharAt(s, str.charAt(e));
            str.setCharAt(e, tmp);
            s++;
            e--;
        }
    }

    public String reverseStrByWords(String str) {
        int s =0, e = 0;
        int len = str.length();
        StringBuilder sb = new StringBuilder(str);
        while(s<len && e<len) {
            while(s<len && sb.charAt(s) == ' ') s++;
            e = s;
            while(e <len && sb.charAt(e) != ' ') e++;
            reverseWord(sb, s, e-1);
            s = e;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        A9_ReverseStrByWords inst = new A9_ReverseStrByWords();
        System.out.println(inst.reverseStrByWords(" a b"));

    }
}
