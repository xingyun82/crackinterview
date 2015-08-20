package string;

/**
 *
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.
 * Created by xingyun on 15/6/16.
 */
public class LC_151_ReverStringWordByWord {

    public void inverse(char[] str, int l, int h) {
        while(l<h) {
            char tmp = str[l];
            str[l] = str[h];
            str[h] = tmp;
            l++;
            h--;
        }

    }


    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<s.length(); ++i) {
            if(s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                if(i!=0 && s.charAt(i-1) != ' ') {
                    sb.append(' ');
                }
            }
        }

        if(sb.length()>0 && sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);

        s = sb.toString();
        if(s.length() == 0) return s;

        char[] str2 = new char[s.length()];
        int l=0, h=s.length()-1;
        while(l<=h) {
            str2[l] = s.charAt(h);
            str2[h] = s.charAt(l);
            l++;
            h--;
        }
        int lw = 0;
        for (int i=0; i<str2.length; ++i) {
            if (str2[i] == ' ') {
                if (str2[lw] != ' ') {
                    inverse(str2, lw, i - 1);
                }
                lw = i+1;
            }
        }
        if(str2[str2.length-1] != ' ' && str2[lw] != ' ') {
            inverse(str2, lw, str2.length-1);
        }

        return new String(str2);
    }

    public static void main(String[] args) {
        String s = "  how do   ";
        LC_151_ReverStringWordByWord inst = new LC_151_ReverStringWordByWord();
        System.out.println(inst.reverseWords(s) + ",");
    }
}
