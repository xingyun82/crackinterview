package dp;

import java.util.HashSet;
import java.util.Set;

public class LC_650_2KeysKeyboard {

    public int minSteps(int n) {
        int[] steps = new int[n+1];
        for (int i=2; i<=n; ++i) {
            steps[i] = Integer.MAX_VALUE;
            for (int j=1; j<=i/2; ++j) {
                if (i%j == 0) {
                    steps[i] = Integer.min(steps[j]+i/j, steps[i]);
                }
            }
        }
        return steps[n];
    }


    public static void main(String[] args) {
//        LC_650_2KeysKeyboard inst = new LC_650_2KeysKeyboard();
//        System.out.println(inst.minSteps(1));
//        System.out.println(inst.minSteps(2));
//        System.out.println(inst.minSteps(3));
//        System.out.println(inst.minSteps(4));
//        System.out.println(inst.minSteps(5));
//        System.out.println(inst.minSteps(6));
//        System.out.println(inst.minSteps(7));

        Set<String> words = new HashSet<>();
        words.add("hello");
        words.add("good");
        System.out.println(words);
    }
}
