package geeksforgeeks;

/**
 * Created by xingyun on 15/8/14.
 */
public class WordMinDistrance {

    //  you are given a array of string followed by two words.
    // You have to find the minimum distance between the two words in the given array of string

    /*
    public int getMinDist(String str, String word1, String word2) {
        int flag = 0;
        int idx1 = 0;
        int idx2 = 0;
        int minDist = Integer.MAX_VALUE;
        String[] words = str.split(" ");
        for(int i=0; i<words.length; ++i) {
            if(words[i].equals(word1)) {
                idx1 = i;
                if(flag == 2) {
                    minDist = Math.min(Math.abs(idx1-idx2), minDist);
                }
                flag = 1;
            }
            else if(words[i].equals(word2)) {
                idx2 = i;
                if(flag == 1) {
                    minDist = Math.min(Math.abs(idx1-idx2), minDist);
                }
                flag = 2;
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        String str = "hello world you fix hello you";
        WordMinDistrance inst = new WordMinDistrance();
        System.out.println(inst.getMinDist(str, "hello", "you"));
    }
    */

    // another similar problem
    // given two sorted int array A[] and B[], find the min delta of A[i]-B[j]

    public int getMinDist(int[] A, int[] B) {
        int i = 0, j = 0;
        int flag = 0;
        int minDist = Integer.MAX_VALUE;
        while(i<A.length && j<B.length) {
            minDist = Math.min(Math.abs(A[i]-B[j]), minDist);
            if(A[i] == B[j]) return 0;
            if(A[i] > B[j]) j++;
            else i++;
        }
        return minDist;
    }

    public static void main(String[] args) {
        WordMinDistrance inst = new WordMinDistrance();
        int[] A = new int[]{5, 15, 25};
        int[] B = new int[]{1, 8, 12, 27, 29};
        System.out.println(inst.getMinDist(A, B));
    }


}
