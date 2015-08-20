package array;

import java.util.*;
/**
 *
 118:
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]


 119:
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].
 ]
 * Created by xingyun on 15/7/10.
 */
public class LC_118_119_PascalTriangle {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) return res;
        Integer[] tmp1 = new Integer[rowIndex+1];
        Integer[] tmp2 = new Integer[rowIndex+1];
        tmp1[0] = 1;
        tmp2[0] = 1;
        for(int i=1; i<=rowIndex; ++i) {
            for(int j=1; j<i; ++j) {
                tmp2[j] = tmp1[j-1] + tmp1[j];
            }
            tmp2[i] = 1;
            for(int k=0; k<tmp2.length; ++k) {
                tmp1[k] = tmp2[k];
            }
        }
        return Arrays.asList(tmp1);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows < 1) return res;
        {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            res.add(row);
        }
        for(int i=1; i<numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j=1; j<i; ++j) {
                row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        LC_118_119_PascalTriangle inst = new LC_118_119_PascalTriangle();
        /*
        List<List<Integer>> res = inst.generate(5);
        for(int i=0;i<res.size();++i) {
            for(int j=0;j<res.get(i).size();++j) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
        */
        List<Integer> res = inst.getRow(4);
        for(int i:res) {
            System.out.println(i + "");
        }
    }
}
