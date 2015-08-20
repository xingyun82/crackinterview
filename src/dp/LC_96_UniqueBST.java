package dp;

/**
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * Created by xingyun on 15/8/19.
 */
public class LC_96_UniqueBST {

    // main idea:
    // suppose S(n) is the unique bst count for n nodes
    // think about from S(n-1) to S(n)
    // the nth node should only be added for three kinds
    // 1. as the root
    // 2. as the right child
    // 3. as the middle right
    // S(i) = 2*S(i-1)+ \sigma_j{S(j)*S(i-1-j)}
    // that is to say:
    // S(i) = \sigma_j{S(j)*S(i-j)} (1<=j<=i-1)
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i=2; i<=n; ++i) {
            for(int j=0; j<i/2; ++j) {
                nums[i] += 2*nums[j]*nums[i-1-j];
            }
            if((i-1)%2 == 0) {
                nums[i] += nums[(i-1)/2]*nums[(i-1)/2];
            }
        }
        return nums[n];
    }
}
