package snapchat;

import java.util.*;

/**
 * 一个类似Unit diff的算法
 * 基本思想是先用Edit Distance算出两个文件的 行edit distance
 * 在backtrack求 行的具体add/remove/change操作时，再对所有的可能改动打分，采用打分最小的改动，
 * 并对改动操作进行merge
 *
 * Created by xingyun on 9/29/15.
 */
public class FileDiff {

    public final static String[] DIFF_TYPE = {"EQUAL", "a", "d", "c"};
    public final static int[] WEIGHTS = {0, 1, 1, 1};
    private int minScore = Integer.MAX_VALUE;

    private String[] file1;
    private String[] file2;

    public FileDiff(String[] file1, String[] file2) {
        this.file1 = file1;
        this.file2 = file2;
    }

    class LineDiffResult {
        int diffType; // 0:equal, 1: add, 2:remove, 3:replace
        List<Integer> lineNo1 = new ArrayList<Integer>();
        List<Integer> lineNo2 = new ArrayList<Integer>();
        public LineDiffResult(int diffType, int lineNo1, int lineNo2) {
            this.diffType = diffType;
            this.lineNo1.add(lineNo1);
            this.lineNo2.add(lineNo2);
        }

        private String lines(List<Integer> lines) {
            if(lines.size() == 1) {
                return "" + lines.get(0);
            } else {
                return lines.get(0) + "," + lines.get(lines.size()-1);
            }
        }

        public String toString() {
            String res = "";
            if(diffType == 1) {
                res = lines(lineNo1) + DIFF_TYPE[1] + lines(lineNo2);
            } else if(diffType == 2) {
                res = lines(lineNo1) + DIFF_TYPE[2] + lines(lineNo2);
            } else if(diffType == 3) {
                res = lines(lineNo1) + DIFF_TYPE[3] + lines(lineNo2);
            }
            return res;
        }
    }

    public int computeScore(List<LineDiffResult> lineDiffs, List<LineDiffResult> newDiff) {
        int res = 0;
        int prevLineNo1 = -1;
        int prevLineNo2 = -1;
        LineDiffResult prevDiff = null;
        for(LineDiffResult diff:lineDiffs) {
            if(diff.lineNo1.get(0) != prevLineNo1) {
                res++;
                if(diff.lineNo1.get(0) == prevLineNo1+1) {
                    if(diff.lineNo2.get(0) == prevLineNo2+1 && diff.diffType == prevDiff.diffType) {
                        prevDiff.lineNo1.add(diff.lineNo1.get(0));
                        prevDiff.lineNo2.add(diff.lineNo2.get(0));
                    }
                } else {
                    prevDiff = new LineDiffResult(diff.diffType, diff.lineNo1.get(0), diff.lineNo2.get(0));
                    newDiff.add(prevDiff);
                }
                prevLineNo1 = diff.lineNo1.get(0);
                prevLineNo2 = diff.lineNo2.get(0);

            } else {
                prevDiff.lineNo2.add(diff.lineNo2.get(0));
                if(prevDiff.diffType != diff.diffType) {
                    prevDiff.diffType = 3;
                }
            }
        }
        return res;
    }

    public void backtrack(List<LineDiffResult> res, List<LineDiffResult> dr, int[][] d, int i, int j) {
        if(i == 0 && j == 0) {
            List<LineDiffResult> tmp = new ArrayList<LineDiffResult>(dr);
            Collections.reverse(tmp);
            List<LineDiffResult> newDiff = new ArrayList<LineDiffResult>();
            int score = computeScore(tmp, newDiff);
            if(score < minScore) {
                res.clear();
                res.addAll(newDiff);
            }
            return;
        }

        if(i>0 && j>0) {
            if(d[i][j] == d[i-1][j-1] && file1[i-1].equals(file2[j-1])) {
                backtrack(res, dr, d, i - 1, j - 1);
            } else if(d[i][j] == d[i-1][j-1]+WEIGHTS[3]) {
                dr.add(new LineDiffResult(3, i, j));
                backtrack(res, dr, d, i - 1, j - 1);
                dr.remove(dr.size()-1);
            }
        }

        if(i>0 && d[i][j] == d[i-1][j]+WEIGHTS[2]) {
            dr.add(new LineDiffResult(2, i, j));
            backtrack(res, dr, d, i-1, j);
            dr.remove(dr.size()-1);
        }
        if(j>0 && d[i][j] == d[i][j-1]+WEIGHTS[1]) {
            dr.add(new LineDiffResult(1, i, j));
            backtrack(res, dr, d, i, j-1);
            dr.remove(dr.size()-1);
        }

    }

    public List<LineDiffResult> diff() {
        List<LineDiffResult> res = new ArrayList<LineDiffResult>();
        List<LineDiffResult> dr = new ArrayList<LineDiffResult>();
        int m = file1.length;
        int n = file2.length;

        int[][] d = new int[m+1][n+1];
        for(int i=0; i<=m; ++i) {
            d[i][0] = i*WEIGHTS[1];
        }
        for(int j=0; j<=n; ++j) {
            d[0][j] = j*WEIGHTS[2];
        }

        for(int i=1; i<=m; ++i) {
            for(int j=1; j<=n; ++j) {
                d[i][j] = Math.min(
                        Math.min(d[i-1][j]+WEIGHTS[2], d[i][j-1]+WEIGHTS[1]),
                        d[i-1][j-1] + (file1[i-1].equals(file2[j-1])?0:WEIGHTS[3])
                        );
            }
        }
        backtrack(res, dr, d, m, n);
        return res;
    }


    public void printDiff(List<LineDiffResult> res) {
        for(LineDiffResult diff:res) {
            System.out.println(diff);
            if(diff.diffType == 1) {
                for (int i : diff.lineNo2) {
                    System.out.println("> " + file2[i - 1]);
                }
            }
            else if(diff.diffType == 2) {
                for(int i: diff.lineNo1) {
                    System.out.println("< " + file1[i-1]);
                }
            }
            else if(diff.diffType == 3) {
                for(int i: diff.lineNo1) {
                    System.out.println("< " + file1[i-1]);
                }
                System.out.println("---");
                for (int i : diff.lineNo2) {
                    System.out.println("> " + file2[i - 1]);
                }
            }
        }
    }



    public static void main(String[] args) {
        String[] file1 = new String[]{
                "",
                ""

        };
        String[] file2 = new String[]{
                "",
                "hello",
                "thanks"
        };
        FileDiff inst = new FileDiff(file1, file2);
        List<LineDiffResult> res = inst.diff();
        inst.printDiff(res);

    }
}
