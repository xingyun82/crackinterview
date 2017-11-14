package tree;

/**
 * 参考：
 * http://blog.csdn.net/L664675249/article/details/50157669
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 */
public class BinaryIndexTree {

/*            n  --> No. of elements present in input array.
    BITree[0..n] --> Array that represents Binary Indexed Tree.
    arr[0..n-1]  --> Input array for whic prefix sum is evaluated. */

    // Returns sum of arr[0..index]. This function assumes
// that the array is preprocessed and partial sums of
// array elements are stored in BITree[].
    public int getSum(int BITree[], int index)
    {
        int sum = 0; // Iniialize result

        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse ancestors of BITree[index]
        while (index>0)
        {
            // Add current element of BITree to sum
            sum += BITree[index];

            // Move index to parent node in getSum View
            index -= index & (-index);
        }
        return sum;
    }

    // Updates a node in Binary Index Tree (BITree) at given index
    // in BITree.  The given value 'val' is added to BITree[i] and
    // all of its ancestors in tree.
    private void updateBIT(int BITree[], int n, int index, int val)
    {
        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse all ancestors and add 'val'
        while (index <= n)
        {
            // Add 'val' to current node of BI Tree
            BITree[index] += val;

            // Update index to that of parent in update View
            index += index & (-index);
        }
    }


    public int[] constructBITree(int arr[], int n) {
        int[] BITree = new int[n+1];
        for (int i=0; i<n; ++i) {
            updateBIT(BITree, n, i, arr[i]);
        }
        return BITree;
    }

    public static void main(String[] args) {
        BinaryIndexTree inst = new BinaryIndexTree();
        int freq[] = {2, 1, 1, 3, 2, 3, 5};
        int n = freq.length;
        int[] BITree = inst.constructBITree(freq, n);
        System.out.println("Sum of elements in arr[0..5] is "
                + inst.getSum(BITree, 5));

        // Let use test the update operation
        //freq[3] += 6;
        inst.updateBIT(BITree, n, 3, 6); //Update BIT for above change in arr[]

        System.out.println("\nSum of elements in arr[0..5] after update is "
                + inst.getSum(BITree, 5));
    }
}
