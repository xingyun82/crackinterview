package string; /**
 * 考点：
 * 字符串转成数字再hash，提高hash的效率
 *
 * Created by xingyun on 15/6/3.
 */
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;


public class LC_187_RepeatDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<Integer>();
        Set<Integer> doubleWords = new HashSet<Integer>();
        List<String> rv = new ArrayList<String>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        LC_187_RepeatDNASequence inst = new LC_187_RepeatDNASequence();
        List<String> res = inst.findRepeatedDnaSequences(s);
        for(String str:res) {
            System.out.println(str);
        }
    }
}
