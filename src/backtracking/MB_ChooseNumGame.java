package backtracking;

import java.util.*;

/**
 * 两个玩家从一组数里轮流取数，取过就从数组拿走，如果某个玩家取
 数后所有已经取出的数和超过给定值则胜出，要求判断第一个拿是否能赢写函数
 可以扩展到k个玩家的情况
 */
/**
 * Created by xingyun on 15/8/17.
 */
public class MB_ChooseNumGame {


    private boolean backtracking(Set<Integer> choosable, int sum, int i, int target, int k) {
        if(sum > target) {
            return i%k == 1;
        }
        if (choosable.isEmpty()) return false;
        if(i%k != 0) { // it's turn to other player
            Integer[] nums = choosable.toArray(new Integer[0]);
            boolean flag = true;
            for (int num : nums) {
                choosable.remove(num);
                if (!backtracking(choosable, sum + num, i + 1, target, k)) flag = false;
                choosable.add(num);
                if(!flag) break;
            }
            return flag;
        } else { // it's turn to first playter
            Integer[] nums = choosable.toArray(new Integer[0]);
            boolean flag = false;
            for (int num : nums) {
                choosable.remove(num);
                if (backtracking(choosable, sum + num, i + 1, target, k)) {
                    flag = true;
                    if(i == 0) System.out.println(num);
                }
                choosable.add(num);
                if(flag) break;
            }

            return flag;
        }
    }

    public boolean isWin(Set<Integer> choosable, int target, int k) {
        return backtracking(choosable, 0, 0, target, k);
    }


    public static void main(String[] args) {
        Set<Integer> choosable = new HashSet<Integer>();
        for(int i=1; i<=5; ++i) {
            choosable.add(i);
        }
        MB_ChooseNumGame inst = new MB_ChooseNumGame();
        System.out.println(inst.isWin(choosable, 10, 3));
    }
}
