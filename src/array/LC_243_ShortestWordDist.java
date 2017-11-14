package array;

import java.util.*;
/**
 *
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.

 For example,

 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding",
 return 1.

 * Created by xingyun on 10/12/15.
 */
public class LC_243_ShortestWordDist {

    // 这个算法可以用来做搜索结果的文本摘要，words可以看成是搜索词列表

    // 算法1
    // main idea: two pointers
    // i: the last position which contains all words
    // j: the first position which contains all words
    // time complexity: O(n)
    // 当搜索词变换时，还要再检索整个text，效率不高
    // 可以用基于索引的方法，先对所有词进行索引，针对索引位置合并，然后再求最小距离 见算法2
    /*
    public int getShortestDist(List<String> text, List<String> words) {
        int shortestDist = Integer.MAX_VALUE;
        int i=0, j=0;
        int find = 0; // how many words found in text between j and i
        // target word freq
        Map<String, Integer> targetWordFreq = new HashMap<String, Integer>();
        // word frequency map in text between j and i
        Map<String, Integer> wordFreq = new HashMap<String, Integer>();
        // initialize word freq map
        for(int k=0; k<words.size(); ++k) {
            String w = words.get(k);
            wordFreq.put(w, 0);
            if(targetWordFreq.containsKey(w)) {
                targetWordFreq.put(w, targetWordFreq.get(w)+1);
            } else {
                targetWordFreq.put(w, 1);
            }
        }
        while(i<text.size()) {
            String wi = text.get(i);
            if(!wordFreq.containsKey(wi)) { i++; continue; }
            int counti = wordFreq.get(wi);
            counti++;
            // find a new word
            if(counti == targetWordFreq.get(wi)) find++;

            wordFreq.put(wi, counti);
            // find all words between j and i
            if(find == targetWordFreq.size()) {
                while(j < i) {
                    String wj = text.get(j);
                    if(!wordFreq.containsKey(wj)) {j++; continue;}
                    int countj = wordFreq.get(wj);
                    countj--;
                    wordFreq.put(wj, countj);
                    if(countj < targetWordFreq.get(wj)) {
                        shortestDist = Math.min(shortestDist, i-j);
                        find--;
                        j++;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }

        return shortestDist;
    }
    */

    // 1. 先对所有词建wordpos索引
    // 2. 对请求词，根据索引merge一个最终的请求词的wordpos列表
    // 3. 利用two pointers算法对请求词wordpos列表 计算最小距离
    // time complexity: O(k)  k是请求词在文件中出现的次数
    private Map<String, List<Integer>> wordPosMap = new HashMap<String, List<Integer>>();

    public LC_243_ShortestWordDist(List<String> text) {
        for(int i=0; i<text.size(); ++i) {
            String w = text.get(i);
            if(!wordPosMap.containsKey(w)) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                wordPosMap.put(w, l);
            } else {
                wordPosMap.get(w).add(i);
            }
        }
    }

    class WordPos {
        String w;
        int idx; // word
        int pos; // word position
        public WordPos(String w, int idx, int pos) { this.w = w; this.idx = idx; this.pos = pos; }
    }


    // 根据请求词查wordpos索引，merge一个最终的wordpos列表
    // word list should not contain any duplicate words
    private List<WordPos> getOrderNodes(List<String> words) {
        List<WordPos> res = new ArrayList<WordPos>();

        List<List<Integer>> wordPosList = new ArrayList<List<Integer>>();
        for(String word:words) {
            wordPosList.add(wordPosMap.get(word));
        }
        PriorityQueue<WordPos> queue = new PriorityQueue<WordPos>(new Comparator<WordPos>() {
            @Override
            public int compare(WordPos o1, WordPos o2) {
                return o1.pos - o2.pos;
            }
        });
        for(int i=0; i<words.size(); ++i) {
            queue.offer(new WordPos(words.get(i), i, wordPosList.get(i).get(0)));
        }
        int[] pointers = new int[words.size()];
        while(!queue.isEmpty()) {
            WordPos wp = queue.poll();
            res.add(wp);
            pointers[wp.idx]++;
            if(pointers[wp.idx] < wordPosList.get(wp.idx).size()) {
                queue.offer(new WordPos(words.get(wp.idx), wp.idx, wordPosList.get(wp.idx).get(pointers[wp.idx])));
            }
        }

        return res;
    }

    // 根据wordpos列表 计算请求词的最短距离
    // word list would contains duplicated words
    public int getShortestDist(List<WordPos> text, List<String> words) {
        int shortestDist = Integer.MAX_VALUE;
        int i=0, j=0;
        int find = 0; // how many words found in text between j and i
        // target word freq
        Map<String, Integer> targetWordFreq = new HashMap<String, Integer>();
        // word frequency map in text between j and i
        Map<String, Integer> wordFreq = new HashMap<String, Integer>();
        // initialize word freq map
        for(int k=0; k<words.size(); ++k) {
            String w = words.get(k);
            wordFreq.put(w, 0);
            if(targetWordFreq.containsKey(w)) {
                targetWordFreq.put(w, targetWordFreq.get(w)+1);
            } else {
                targetWordFreq.put(w, 1);
            }
        }
        while(i<text.size()) {
            String wi = text.get(i).w;
            if(!wordFreq.containsKey(wi)) { i++; continue; }
            int counti = wordFreq.get(wi);
            counti++;
            // find a new word
            if(counti == targetWordFreq.get(wi)) find++;

            wordFreq.put(wi, counti);
            // find all words between j and i
            if(find == targetWordFreq.size()) {
                while(j < i) {
                    String wj = text.get(j).w;
                    if(!wordFreq.containsKey(wj)) {j++; continue;}
                    int countj = wordFreq.get(wj);
                    countj--;
                    wordFreq.put(wj, countj);
                    if(countj < targetWordFreq.get(wj)) {
                        shortestDist = Math.min(shortestDist, text.get(i).pos-text.get(j).pos);
                        find--;
                        j++;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }

        return shortestDist;
    }

    private List<String> filterDuplicates(List<String> words) {
        List<String> res = new ArrayList<String>();
        Set<String> dict = new HashSet<String>();
        for(String w:words) {
            if(!dict.contains(w)) {
                dict.add(w);
                res.add(w);
            }
        }
        return res;
    }
    // time complexity: O(k)
    public int getShortestDist2(List<String> words) {

        List<WordPos> text = getOrderNodes(filterDuplicates(words));
        return getShortestDist(text, words);

    }

    public static void main(String[] args) {
        List<String> text = new ArrayList<String>();
        text.add("A");
        text.add("B");
        text.add("C");
        text.add("D");
        text.add("B");
        text.add("E");
        text.add("F");
        text.add("C");
        text.add("D");
        text.add("A");
        text.add("D");
        text.add("E");
        LC_243_ShortestWordDist inst = new LC_243_ShortestWordDist(text);
        List<String> words = new ArrayList<String>();
        words.add("D");
        words.add("D");
        words.add("F");
        System.out.println(inst.getShortestDist2(words));
    }
}
