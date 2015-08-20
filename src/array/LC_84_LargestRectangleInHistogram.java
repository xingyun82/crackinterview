package array;

import java.util.*;
/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given height = [2,1,5,6,2,3],
 return 10.
 * Created by xingyun on 15/8/19.
 */
public class LC_84_LargestRectangleInHistogram {
    /**
     * Main idea: compute the largest rectangle for each bar, and return the largest of them
     * the left bound of the largest rectangle for a bar is the first bar smaller than it on the left
     * the right bound is the first bar smaller than it on the right
     * We can use stack to store the bars in ascendant order, then when meet a bar x smaller than the top bar,
     * we can know that the right bound is x, and left bound is the one under the top bar in stack.
     *
     */
    public int largestRectangleArea(int[] height) {

        if(height == null || height.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int len = height.length;
        int h = 0;
        while(i <= len) {
            h = (i == len)?0:height[i];
            if(stack.empty() || height[stack.peek()] < h) {
                stack.push(i++);
            } else {
                int bar = stack.pop();
                int tmpArea = (stack.empty()?i:(i-stack.peek()-1))*height[bar];
                maxArea = Math.max(maxArea,tmpArea);
            }
        }
        return maxArea;
    }

}
