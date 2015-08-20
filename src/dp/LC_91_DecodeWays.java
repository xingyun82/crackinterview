package dp;

/**
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 * Created by xingyun on 15/8/19.
 */
public class LC_91_DecodeWays {

    int count;
    // main idea: dyanmic-programming
    // suppose N(i) is the number of decodings end with ith character.
    //
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;

        int res = 0;
        int[] N = new int[s.length()];

        for(int i=0; i<N.length; ++i) {
            if(i == 0) {
                if(s.charAt(i) < '1' || s.charAt(i) > '9') return 0;
                N[0] = 1; continue;
            }
            if(s.charAt(i) == '0') {
                if(s.charAt(i-1) <= '2' && s.charAt(i-1) >= '1') {
                    N[i] = (i==1?1:N[i-2]);
                } else {
                    return 0;
                }
            } else if(s.charAt(i) <= '6' && s.charAt(i) >= '1') {
                if(s.charAt(i-1) <= '2' && s.charAt(i-1) >= '1') {
                    N[i] = N[i-1] + (i==1?1:N[i-2]);
                } else {
                    N[i] = N[i-1];
                }
            } else if(s.charAt(i) > '6' && s.charAt(i) <= '9') {
                if(s.charAt(i-1) <= '1' && s.charAt(i-1) >= '1') {
                    N[i] = N[i-1] + (i==1?1:N[i-2]);
                } else {
                    N[i] = N[i-1];
                }
            } else {
                return 0;
            }
        }
        return N[N.length-1];
    }
}
