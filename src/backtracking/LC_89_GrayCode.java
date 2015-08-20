package backtracking;

import java.util.*;
/**
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * Created by xingyun on 15/8/19.
 */
public class LC_89_GrayCode {

    // main idea: find math rule
    // intial: 0, 1, delta = 1
    // each step: delta = delta*2
    // then, the gray code is symmetric without the highest bit
    // 0 0 0 (0)
    // 0 0 1 (1)
    // 0 1 1 (3)
    // 0 1 0 (2)
    // -----------
    // 1 1 0 (6)
    // 1 1 1 (7)
    // 1 0 1 (5)
    // 1 0 0 (4)
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n==0) { res.add(0); return res; }
        res.add(0); res.add(1);
        int delta = 1;

        for(int i=1; i<n; ++i) {
            int len = res.size();
            delta *= 2;
            for(int j=len-1; j>=0; j--) {
                res.add(res.get(j)+delta);
            }
        }
        return res;
    }
}
