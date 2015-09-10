package array;

import common.Utility;

/**
 * 假设一个有序数组里，有两个数的顺序颠倒了，请恢复过来
 * 例如：1,5,3,4,2,6
 * 5和2颠倒了
 *
 * Created by xingyun on 15/9/9.
 */
public class UnorderedTwoNums {

    // 记录逆序数对，如果只有一对，则交换该逆序数对
    // 如果有两队，则交换第一对的前一个数 和 第二队的 后一个数
    // O(n)
    public void reorder(int[] A) {
        int i = 0, j = 0; // suppose a and b is unordered

        int unorder = 0;
        for(int k=0; k<A.length-1; ++k) {
            if(A[k] > A[k+1]) {
                if(unorder == 0) { i = k; unorder++; }
                j = k+1;
            }
        }
        // swap a and b
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        UnorderedTwoNums inst = new UnorderedTwoNums();
        int[] A = {1,3,2,4,5,6};
        inst.reorder(A);
        for(int i:A) System.out.print(i+",");
    }
}
