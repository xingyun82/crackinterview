package facebook;

/**
 * 判断两个数字流是否最多只有一个不同
 * Created by xingyun on 15/7/13.
 */
class IntFileIterator {

    private int pointer;
    private int[] data;

    public IntFileIterator(int[] data) {
        this.data = data;
        this.pointer = 0;
    }

    public boolean hasNext() {
        return pointer < data.length;
    }

    public int next() {
        return data[pointer++];
    }


}

public class FileOneEditDistance {

    public boolean isDistanceZeroOrOne(IntFileIterator a,
                                       IntFileIterator b) {
        boolean ins_a = false, ins_b = false, replace = false, diff = false;
        int pre_a = 0;
        int pre_b = 0;
        while (a.hasNext() && b.hasNext()) {
            int cur_a = a.next(), cur_b = b.next();
            if (!ins_a && !ins_b && !replace) {
                if (cur_a != cur_b) {
                    ins_a = ins_b = replace = diff = true;
                }
            } else {
                if (ins_b && pre_b != cur_a) ins_b = false;
                if (ins_a && pre_a != cur_b) ins_a = false;
                if (replace && cur_a != cur_b) replace = false;
                if (!ins_a && !ins_b && !replace) return false;
            }
            pre_a = cur_a;
            pre_b = cur_b;
        }

        if (!a.hasNext() && !b.hasNext()) {
            return !diff || replace;
        } else if (a.hasNext()) {
            int cur_a = a.next();
            return (!diff || (ins_b && pre_b == cur_a)) && !a.hasNext();
        } else if (b.hasNext()) {
            int cur_b = b.next();
            return (!diff || (ins_a && pre_a == cur_b)) && !b.hasNext();
        }
        return false;
    }

    public static void main(String[] args) {
        IntFileIterator itera = new IntFileIterator(new int[]{1,1,2,3});
        IntFileIterator iterb = new IntFileIterator(new int[]{1,2,3});

        FileOneEditDistance inst = new FileOneEditDistance();
        System.out.println(inst.isDistanceZeroOrOne(itera, iterb));
    }

}
