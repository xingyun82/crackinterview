package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_299_BullAndCows {

    private Map<Character, Set<Integer>> genCharPosMap(String str) {
        Map<Character, Set<Integer>> charPosMap = new HashMap<>();
        for (int i=0; i<str.length(); ++i) {
            char c = str.charAt(i);
            if (charPosMap.containsKey(c)) {
                charPosMap.get(c).add(i);
            } else {
                Set<Integer> posSet = new HashSet<>();
                posSet.add(i);
                charPosMap.put(c, posSet);
            }
        }
        return charPosMap;
    }


    private int sameCount(Set<Integer> set1, Set<Integer> set2) {
        int res = 0;
        for (int num : set1) {
            if (set2.contains(num)) {
                res++;
            }
        }
        return res;
    }

    private String genHint(Map<Character, Set<Integer>> secretCharPosMap,
                           Map<Character, Set<Integer>> guessCharPosMap) {
        int bulls = 0;
        int cows = 0;
        for (char c : guessCharPosMap.keySet()) {
            if (secretCharPosMap.containsKey(c)) {
                Set<Integer> secretPosSet = secretCharPosMap.get(c);
                Set<Integer> guessPosSet = guessCharPosMap.get(c);
                int sameCount = sameCount(secretPosSet, guessPosSet);
                bulls += sameCount;
                cows += Integer.min(secretPosSet.size(), guessPosSet.size()) - sameCount;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHint(String secret, String guess) {
        return genHint(genCharPosMap(secret), genCharPosMap(guess));
    }

    public static void main(String[] args) {
        LC_299_BullAndCows inst = new LC_299_BullAndCows();
        System.out.println(inst.getHint("0", "7810"));
    }
}
