package string;

/**
 * Created by xingyun on 15/8/8.
 */
public class LC_205_Isomorphic {

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        char[] mapto = new char[256];
        char[] mapfrom = new char[256];

        for(int i=0; i<s.length();++i) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(mapto[sc] == 0) {
                mapto[sc] = tc;
            } else {
                if(mapto[sc] != tc) return false;
            }
            if(mapfrom[tc] == 0) {
                mapfrom[tc] = sc;
            } else {
                if(mapfrom[tc] != sc) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC_205_Isomorphic inst = new LC_205_Isomorphic();
        System.out.println(inst.isIsomorphic("a", "a"));
    }
}
