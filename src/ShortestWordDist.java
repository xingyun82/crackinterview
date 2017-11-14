
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 这道题考察了好几个重点：
 * 1) PriorityQueue
 * 2) Two pointers
 * 3) Inverted index
 */
public class ShortestWordDist {

    private Map<String, Integer> wordIndexMap = new HashMap<>();
    private Map<Integer, List<Integer>> wordPosMap = new HashMap<>();

    class WordPos {
        int wIdx;
        int pos;
        WordPos(int idx, int pos) {
            this.wIdx = idx;
            this.pos = pos;
        }
    }

    public ShortestWordDist(List<String> text) {
        int count = 0;
        for (int i=0; i<text.size(); ++i) {
            String word = text.get(i);
            // update word index map
            if (!wordIndexMap.containsKey(word)) {wordIndexMap.put(word, count++);
                wordIndexMap.put(word, count++);
            }
            int idx = wordIndexMap.get(word);
            // update word pos map
            if (wordPosMap.containsKey(idx)) {
                wordPosMap.get(idx).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                wordPosMap.put(idx, l);
            }
        }
    }

    private Map<Integer, Integer> getFreqMap(List<String> words) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            int idx = wordIndexMap.get(word);
            if (!freqMap.containsKey(idx)) {
                freqMap.put(idx, 1);
            } else {
                freqMap.put(idx, freqMap.get(idx)+1);
            }
        }
        return freqMap;
    }

    // time: O(m*logk), k is the number of words, m is the max length of word pos lists.
    private List<WordPos> getWordPosList(Set<String> words) {
        List<WordPos> wordPosList = new ArrayList<>();
        Queue<WordPos> queue = new PriorityQueue<>((o1, o2) -> o1.pos - o2.pos);
        Map<Integer, Integer> curMap = new HashMap<>();

        for (String word : words) {
            int wIdx = wordIndexMap.get(word);
            List<Integer> posList = wordPosMap.get(wIdx);
            if (posList.size() > 0) {
                queue.offer(new WordPos(wIdx, posList.get(0)));
                curMap.put(wIdx, 0);
            }
        }
        while (!queue.isEmpty()) {
            WordPos wordPos = queue.poll();
            wordPosList.add(wordPos);
            int wIdx = wordPos.wIdx;
            curMap.put(wIdx, curMap.get(wIdx)+1);
            int cur = curMap.get(wIdx);
            if (cur < wordPosMap.get(wIdx).size()) {
                queue.offer(new WordPos(wIdx, wordPosMap.get(wIdx).get(cur)));
            }
        }
        return wordPosList;
    }

    // two pointer method:
    // move i to cover all words, then move j to find the shortest distance
    // time: O(n), n is the length of word pos list.
    private int getShortestDist(List<WordPos> wordPosList, Map<Integer, Integer> freqMap) {
        int minDist = Integer.MAX_VALUE;
        int i=0, j=0;
        Map<Integer, Integer> tmpFreqMap = new HashMap<>();
        int find = 0;
        while (i < wordPosList.size()) {
            int idx = wordPosList.get(i).wIdx;
            if (!tmpFreqMap.containsKey(idx)) {
                tmpFreqMap.put(idx, 1);
            } else {
                tmpFreqMap.put(idx, tmpFreqMap.get(idx)+1);
            }
            if (tmpFreqMap.get(idx) >= freqMap.get(idx)) {
                find++;
            }
            if (find == freqMap.size()) {
                while (j < i) {
                    int idxj = wordPosList.get(j).wIdx;
                    tmpFreqMap.put(idxj, tmpFreqMap.get(idxj) - 1);
                    if (tmpFreqMap.get(idxj) < freqMap.get(idxj)) {
                        minDist = Math.min(minDist, wordPosList.get(i).pos - wordPosList.get(j).pos);
                        find--;
                        j++;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
        return minDist;
    }

    // 0. support multiple input words
    // 1. support duplication in words
    // 2. optimized for multiple call
    public int getShortestDist(List<String> words) {
        // construct freq map of input words
        Map<Integer, Integer> freqMap = getFreqMap(words);
        // get word pos list ordered by position
        List<WordPos> wordPosList = getWordPosList(new HashSet<>(words));
        // get shortest distance
        return getShortestDist(wordPosList, freqMap);
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
        ShortestWordDist inst = new ShortestWordDist(text);
        List<String> words = new ArrayList<String>();
        words.add("D");
        words.add("D");
        words.add("F");
        System.out.println(inst.getShortestDist(words));
    }
}
