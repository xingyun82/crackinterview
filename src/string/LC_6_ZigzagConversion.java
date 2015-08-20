package string;

/**
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * Created by xingyun on 15/8/20.
 */
public class LC_6_ZigzagConversion {

    public String convert(String s, int nRows) {
        StringBuffer res = new StringBuffer();
        if (nRows == 1) return s;
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
}
