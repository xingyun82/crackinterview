package facebook;


import java.util.*;
import java.util.List;

/**
 * Created by xingyun on 9/29/15.
 */
public class ListPermutation {


    public void doPermutation(List<String> res, StringBuilder word, String[] strs, int[] curs) {
        //if(curs[0] == str[0].length()) return;
        res.add(word.toString());

        int i = strs.length-1;
        curs[i]++;
        while(curs[i] == strs[i].length()) {
            curs[i] = 0;
            word.setCharAt(i, strs[i].charAt(0));
            i--;
            if(i < 0) return;
            curs[i]++;
        }
        word.setCharAt(i, strs[i].charAt(curs[i]));
        doPermutation(res, word, strs, curs);

    }

    public List<String> permutation(List<String> strs) {
        int n = strs.size();
        List<String> res = new ArrayList<String>();
        StringBuilder word = new StringBuilder();
        for(String str:strs) {
            word.append(str.charAt(0));
        }
        doPermutation(res, word, strs.toArray(new String[0]), new int[n]);
        return res;
    }

    public static void main(String[] args) {
        ListPermutation inst = new ListPermutation();
        List<String> strs = new ArrayList<String>();
        strs.add("abc");
        List<String> res = inst.permutation(strs);
        for(String str:res) {
            System.out.println(str);
        }
    }
}
