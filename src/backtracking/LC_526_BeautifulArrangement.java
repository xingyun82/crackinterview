package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_526_BeautifulArrangement {

    private int count = 0;

    private void backTrack(int pos, boolean[] used, int target) {
        if (pos == target) {
            count++;
        } else {
            for (int i=0; i< target; ++i) {
                if (!used[i] && isBeautiful(pos + 1, i+1)) {
                    used[i] = true;
                    backTrack(pos+1, used, target);
                    used[i] = false;
                }
            }
        }
    }

    private boolean isBeautiful(int idx, int val) {
        return (val % idx == 0 || idx % val == 0);
    }


    public int countArrangement(int N) {
        boolean[] used = new boolean[N];
        backTrack(0, used, N);
        return count;
    }


    public static void main(String[] args) {
        LC_526_BeautifulArrangement inst = new LC_526_BeautifulArrangement();
        System.out.println(inst.countArrangement(4));
    }
}
