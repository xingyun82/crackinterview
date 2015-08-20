package dp;

/**
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

 -2 (K)	-3	3
 -5	-10	1
 10	30	-5 (P)

 Notes:

 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

 * Created by xingyun on 15/6/3.
 */
public class LC_174_DungeonGame {

    /*
    public int dp(int[][] dungeon, int x, int y, int dest) {
        if(x<0 || y<0) return Integer.MAX_VALUE;

        int destPower = dest - dungeon[x][y];
        if(x==0 && y==0) return destPower;
        int leftNeedPower = Integer.MAX_VALUE;
        int upNeedPower = Integer.MAX_VALUE;
        if(y>0) {
            leftNeedPower = dp(dungeon, x, y - 1, destPower);
            leftNeedPower = leftNeedPower>0?leftNeedPower:Integer.MAX_VALUE;
        }
        if(x>0) {
            upNeedPower = dp(dungeon, x - 1, y, destPower);
            upNeedPower = upNeedPower>0?upNeedPower:Integer.MAX_VALUE;
        }
        return Math.min(leftNeedPower, upNeedPower);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        return dp(dungeon, dungeon.length-1, dungeon[0].length-1, 1);
    }
*/

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] health = new int[m][n];

        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }

        return health[0][0];
    }
    public static void main(String[] args) {
        int[][] dungeon = new int[3][];
        dungeon[0] = new int[]{-2,-3,3};
        dungeon[1] = new int[]{-5,-10,1};
        dungeon[2] = new int[]{10,30,-5};

        LC_174_DungeonGame inst = new LC_174_DungeonGame();
        int res = inst.calculateMinimumHP(dungeon);
        System.out.println(res);
    }


}
