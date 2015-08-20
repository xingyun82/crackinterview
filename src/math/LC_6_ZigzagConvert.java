package math;

/**
 * Created by xingyun on 15/2/7.
 */
public class LC_6_ZigzagConvert {

    public String convert(String s, int nRows) {
        StringBuffer res = new StringBuffer();
        if (nRows == 1) return s; // 注意边界情况
        for(int i=0; i<nRows; ++i) {
            if (i == 0 || i == nRows - 1) {
                for (int j=i; j<s.length(); j+= 2*(nRows-1)) {
                    res.append(s.charAt(j));
                }
            } else {
                for (int j=i; j<s.length(); j+= 2*(nRows-1)) {
                    res.append(s.charAt(j));
                    if (j+2*(nRows-1)-2*i < s.length()) {
                        res.append(s.charAt(j + 2 * (nRows - 1) - 2 * i));
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LC_6_ZigzagConvert obj = new LC_6_ZigzagConvert();
        System.out.println(obj.convert("A", 1));
    }
}
