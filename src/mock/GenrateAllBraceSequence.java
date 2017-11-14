package mock;

import com.sun.tools.javah.Gen;

import java.util.HashSet;
import java.util.Set;

public class GenrateAllBraceSequence {

    public Set<String> generate(int num) {
        Set<String> result = new HashSet<>();
        doGenerate(result, "", 0, 0, num);
        return result;
    }

    private void doGenerate(Set<String> result, String curStr, int lc, int rc, int num) {
        if (rc > lc || lc > num || rc > num) return;
        if (lc == num && rc == num) {
            result.add(curStr);
            return;
        }
        doGenerate(result, curStr+"(", lc+1, rc, num);
        doGenerate(result, curStr + ")", lc, rc+1, num);
    }

    public static void main(String[] args) {
        GenrateAllBraceSequence inst = new GenrateAllBraceSequence();
        System.out.println(inst.generate(3));
    }
}
