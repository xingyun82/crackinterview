package unionfind;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

 Example 1:
 Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.
 Example 2:
 Input:
 [[1,1,0],
 [1,1,1],
 [0,1,1]]
 Output: 1
 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 Note:
 N is in range [1,200].
 M[i][i] = 1 for all students.
 If M[i][j] = 1, then M[j][i] = 1.
 */
public class LC_547_FriendCircles {

    // 经典Union-Find算法的应用
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] arr = new int[n];
        for (int i=0; i<arr.length; ++i) {
            arr[i] = i;
        }
        for (int i=0; i<n; ++i) {
            for (int j=0; j<i; ++j) {
                if (M[i][j] != 0) {
                    union(arr, i, j);
                }
            }
        }
        int sc = 0;
        for (int i=0; i<n; ++i) {
            if (arr[i] == i) {
                sc++;
            }
        }
        return sc;
    }

    private void union(int[] arr, int i, int j) {
        int si = find(arr, i);
        int sj = find(arr, j);
        arr[si] = sj;
    }

    private int find(int[] arr, int i) {
        if (i != arr[i]) {
            arr[i] = find(arr, arr[i]);
        }
        return arr[i];
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 1},
        };
        LC_547_FriendCircles inst = new LC_547_FriendCircles();
        System.out.println(inst.findCircleNum(M));
    }

}
