package string;

import common.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_648_ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        dict.forEach(word -> trie.addWord(word));
        String[] tokens = sentence.split(" ");

        for (String token : tokens) {
            String rootWord = trie.coverWord(token);
            if (rootWord != null) {
                result.add(rootWord);
            } else {
                result.add(token);
            }
        }
        return String.join(" ", result);
    }

    public static void main(String[] args) {
        LC_648_ReplaceWords inst = new LC_648_ReplaceWords();
        List<String> dict = Arrays.asList("cat", "bat", "rat", "c");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(inst.replaceWords(dict, sentence));
    }
}
