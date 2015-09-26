package bitmagic;

/**
 * 用位操作求两个数的和
 * 提示：两个bit的和 可以用异或(^)表示，进位可以用与(&)表示
 * Created by xingyun on 9/26/15.
 */
public class Sum {

    int sum(int x, int y) {
        if(y == 0) return x;
        return sum(x^y, (x&y)<<1);
    }

    // 非递归解法
    int sum2(int x, int y) {
        while(y!=0) {
            int carry = x&y;
            x = x^y;
            y = carry << 1;
        }
        return x;
    }
}
