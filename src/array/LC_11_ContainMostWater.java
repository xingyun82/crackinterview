package array;

/**
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.

 * Created by xingyun on 15/8/23.
 */
public class LC_11_ContainMostWater {

    // main idea: two pointer
    // suppose ai and aj is left and right border respectively, the water volume is vij = min(ai, aj)*(j-i)
    //    |                |
    //    ai              aj
    // if ai < aj, then, we have to move ai to ai+1
    // because if move aj to aj-1, then new container volume is aboslutely less than vij

    // follow up: if we can slant the container, this algorithm is not suitable
    // in this case, the complexity may be O(n^2)

    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int i = 0, j = height.length-1;
        int maxVol = 0;
        while(i<j) {
            int min = Math.min(height[i], height[j]);
            maxVol = Math.max(maxVol, min*(j-i));
            if(height[i] == min) i++;
            else j--;
        }
        return maxVol;
    }


}
