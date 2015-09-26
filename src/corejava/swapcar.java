package corejava;

/**
 *
 * begin:   1   2  3   0   4

 0   2  3   1   4
 3   2  0   1   4

 3   2  1   0   4
 3   2  1   4   0

 3   2  0   4   1

 end:     3   2  0   4   1

 Move(int[] begin, int[] end) {
 }

 begin 表示 5个停车位， 0是空的，要求每次只能和 空车位 进行交换，最后达到 最
 终的结果end. 请教 如何 解答。

 * Created by xingyun on 9/23/15.
 */
public class swapcar {

    public void swap(int[] A, int i, int j, int[] map) {

        map[A[i]] = j;
        map[A[j]] = i;

        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;

    }

    public void move(int[] begin, int[] end) {
        int n = end.length;
        int[] map = new int[n]; // value->position in begin array
        for(int i=0; i<n; ++i) {
            map[begin[i]] = i;
        }
        for(int i=0; i<n; ++i) {
            if(begin[i] == end[i]) continue;
            swap(begin, i, map[0], map); // swap current number with empty position
            swap(begin, map[end[i]], map[0], map); // swap target number with empty position
        }
    }


    public static void main(String[] args) {
        int[] begin = {3,2,0,4,1};
        int[] end = {3,2,0,4,1};
        swapcar inst = new swapcar();
        inst.move(begin, end);
        for(int i:begin) {
            System.out.print(i + " ");
        }
    }
}
