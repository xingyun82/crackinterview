package array;

import java.util.Arrays;

public class LC_475_Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        LC_475_Heaters inst = new LC_475_Heaters();
        System.out.println(inst.findRadius(houses, heaters));
    }
}
