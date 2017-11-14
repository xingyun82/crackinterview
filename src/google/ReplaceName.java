package google;


import java.util.ArrayList;
import java.util.List;

/**
 * Write a program which generates permutation of upper cases for target alphabets.
 * For example, target alphabets are "ap" and an input string is "airplane".
 * Then outputs should be "airplane", "Airplane", "airPlane", "airplAne", "AirPlane", "AirplAne", "airPlAne" and "AirPlAne"

 // idea:
 // 1. locate all positions of target alphabets in string
 // 2. get permuation on these positions and change the original string at the same time.
 // 0, 3, 5
 // original one, 0, 3, 5, (0,3), (0,5), (3,5), (0,3,5)
 */
public class ReplaceName {

    private List<Integer> locatePositions(String targetAlphabets, String word) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (targetAlphabets.indexOf(c) != -1) {
                result.add(i);
            }
        }
        return result;
    }

    private void backTracking(List<String> result, List<Integer> tmpPositions, int cur, String word, List<Integer> positions) {
        // change characters in tmp positions for the word, and add it to result
        char[] chArray = word.toCharArray();
        for (int pos : tmpPositions) {
            char c = word.charAt(pos);
            chArray[pos] = String.valueOf(c).toUpperCase().charAt(0);
        }
        result.add(new String(chArray));
        for (int i=cur+1; i<positions.size(); ++i) { // loop all candidates of next step
            tmpPositions.add(positions.get(i));
            backTracking(result, tmpPositions, i, word, positions);
            tmpPositions.remove(tmpPositions.size()-1);
        }
    }

    public List<String> genPermutation(String targetAlphabets, String word) {
        List<Integer> positions = locatePositions(targetAlphabets, word);
        List<String> result = new ArrayList<>();
        List<Integer> tmpPositions = new ArrayList<>();
        backTracking(result, tmpPositions, -1, word, positions);
        return result;
    }

    public static void main(String[] args) {
        ReplaceName inst = new ReplaceName();
        System.out.println(inst.genPermutation("ap", "airplane"));
    }
}
