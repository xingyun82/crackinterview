package bitmagic;

/**
 *
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer


 * Created by xingyun on 9/26/15.
 */
public class LC_190_ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        for (int i=0; i<16; ++i) {
            int highone = 1<<(31-i);
            int lowone = 1<<i;
            int high = n&highone;
            int low = n&lowone;
            if(high == 0 && low !=0) {
                // low 那位变成0
                // high 那位变成1
                n = highone|n;
                n = (~lowone)&n;
            } else if (high!=0 && low==0) {
                // high那位变成0
                // low那位变成1
                n = (~highone)&n;
                n = lowone|n;
            }
        }
        return n;
    }
}
