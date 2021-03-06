package unionfind;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

 The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

 The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

 Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

 Example 1:
 Input: [[1,2], [1,3], [2,3]]
 Output: [2,3]
 Explanation: The given undirected graph will be like this:
 1
 / \
 2 - 3
 Example 2:
 Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 Output: [1,4]
 Explanation: The given undirected graph will be like this:
 5 - 1 - 2
 |   |
 4 - 3
 Note:
 The size of the input 2D-array will be between 3 and 1000.
 Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.


 */
public class LC_684_RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        // get nodes count
        int N = 0;
        for (int i=0; i<edges.length; ++i) {
            N = Math.max(N, Math.max(edges[i][0], edges[i][1]));
        }
        int[] arr = new int[N];
        for (int i=0; i<arr.length; ++i) {
            arr[i] = i;
        }

        for (int i=0; i<edges.length; ++i) {
            int ri = find(arr, edges[i][0]-1);
            int rj = find(arr, edges[i][1]-1);
            if (ri == rj) return edges[i];
            arr[ri] = rj;
        }

        return null;
    }
    // 简化版
    private int find(int[] arr, int i) {
        if (i != arr[i]) {
            arr[i] = find(arr, arr[i]);
        }
        return arr[i];
    }

//    private int find(int[] arr, int i) {
//        int r = i;
//        while (arr[r] != r) {
//            r = arr[r];
//        }
//        while (i != r) {
//            int tmp = arr[i];
//            arr[i] = r;
//            i = tmp;
//        }
//        return r;
//    }

    public static void main(String[] args) {
        int[][] edges = {
                //{1,2}, {2,3}, {3,4}, {1,4}, {1,5}
                {1,2}, {1,3}, {2,3}
        };
        LC_684_RedundantConnection inst = new LC_684_RedundantConnection();
        int[] edge = inst.findRedundantConnection(edges);
        System.out.println(edge[0] + "," + edge[1]);
    }

}
