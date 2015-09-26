package corejava;

/**
 * Created by xingyun on 9/24/15.
 */
public class Base62 {

    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int BASE = ALPHABET.length();

    public String fromBase10(int i) {
        StringBuffer sb = new StringBuffer();
        while(i>0) {
            int r = i % BASE;
            sb.append(ALPHABET.charAt(r));
            i = i / BASE;
        }
        return sb.reverse().toString();
    }

    public int toBase10(String str) {
        int n = str.length();
        int res = 0;
        for(int i=0; i<n; ++i) {
            res = res*BASE + ALPHABET.indexOf(str.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Base62 inst = new Base62();
        String str = inst.fromBase10(232533435);
        System.out.println(str);
        System.out.println(inst.toBase10(str));
    }

}
