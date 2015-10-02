package zenefits;

import java.util.*;
/**
 * Created by xingyun on 9/26/15.
 */
public class MaxChainLength {

    // decide if A can be deduced by B
    static boolean one_distance(String A, String B) {
        if(A.length() > B.length()) return one_distance(B, A);
        if(A.length() + 1 != B.length()) return false;
        int i = 0, j = 0;
        boolean editOne = false;
        while(i<A.length() && j<B.length()) {
            if(A.charAt(i) == B.charAt(j)) {
                i++; j++;
            } else {
                if(editOne) return false;
                editOne = true;
                j++;
            }
        }
        return true;
    }

    static class Node {
        int len;
        String word;
    }

    static int longest_chain(String[] w) {
        int maxLen = 50000;
        int[] dp = new int[maxLen];
        Map<String, Integer> maxLengthMap = new HashMap<String, Integer>();
        List<Node> list = new ArrayList<Node>();
        for(String word:w) {
            Node node = new Node();
            node.len = word.length();
            node.word = word;
            list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.len - o2.len;
            }
        });
        int N = list.size();
        Arrays.sort(w);
        /*
        maxLengthMap.put(list.get(0).word, 0);
        dp[0] = 1;

        int maxChainLength = 1;
        for(int i=1; i<N; ++i) {
            dp[i] = 1;
            String s = list.get(i).word;

            int size = s.length();
            for(int j=0; j<size; ++j) {
                String tmpStr = s.substring(0, j) + s.substring(j+1);
                if(maxLengthMap.containsKey(tmpStr)) {
                    int idx = maxLengthMap.get(tmpStr);
                    dp[i] = Math.max(dp[i], dp[idx]+1);
                }
            }
            maxChainLength = Math.max(maxChainLength, dp[i]);
            maxLengthMap.put(s, i);
        }
        */

        int maxChainLength = 1;
        for(int i=0; i<N; ++i) {
            String s = list.get(i).word;
            int len = 1;
            for(int j=0; j<s.length(); ++j) {
                String tmp = s.substring(0, j) + s.substring(j+1);
                if(maxLengthMap.containsKey(tmp)) {
                    len = Math.max(len, maxLengthMap.get(tmp)+1);
                }
            }
            maxChainLength = Math.max(maxChainLength, len);
            maxLengthMap.put(s, len);
        }

        return maxChainLength;
    }

    public static void main(String[] args) {
        String[] w = { "a", "bc", "ab", "cd", "bca", "bcda", "abcde"};
        System.out.println(longest_chain(w));
    }
}
