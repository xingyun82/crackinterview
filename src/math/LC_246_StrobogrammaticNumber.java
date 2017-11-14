package math;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class LC_246_StrobogrammaticNumber {

    /**
     * 0 - 0
     * 1 - 1
     * 6 - 9
     * 8 - 8
     * 9 - 6
     */
    public boolean isStrobogrammaticNumber(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('6', '9');
        map.put('1', '1');
        map.put('8', '8');
        map.put('9', '6');
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (map.get(str.charAt(i)) == str.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return i > j;
    }

    public static void main(String[] args) {
        LC_246_StrobogrammaticNumber inst = new LC_246_StrobogrammaticNumber();
        System.out.println(inst.isStrobogrammaticNumber("818"));
        System.out.println(inst.isStrobogrammaticNumber("69"));
        System.out.println(inst.isStrobogrammaticNumber("96"));
        System.out.println(inst.isStrobogrammaticNumber("99"));
        System.out.println(inst.isStrobogrammaticNumber("0"));
    }

}
