package string;


import java.util.*;

/**
 *
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.

 * Created by xingyun on 15/7/30.
 */
public class LC_68_AdjustText {

    // append spaces in a stringbuilder
    private void appendSpaces(StringBuilder sb, int spaceCount) {
        for(int i=0; i<spaceCount; ++i) {
            sb.append(' ');
        }
    }
    // adjust one text line
    private String adjustLine(List<String> tmpLine, int tmpLen, int maxWidth, boolean lastLine) {
        StringBuilder res = new StringBuilder();
        int wordCount = tmpLine.size();
        int spaceCount = wordCount - 1;
        // if only one word, just fill in the line with spaces behind the word
        if(spaceCount == 0) {
            res.append(tmpLine.get(0));
            appendSpaces(res, maxWidth-tmpLine.get(0).length());
            return res.toString();
        }
        // if the last line
        if(lastLine) {
            for(int i=0;i<wordCount-1;++i) {
                res.append(tmpLine.get(i));
                res.append(' ');
            }
            res.append(tmpLine.get(wordCount-1));
            appendSpaces(res, maxWidth-(tmpLen-1));
            return res.toString();
        }
        // other wise, we should distribute the spaces evenly
        int totalSpace = maxWidth - (tmpLen - wordCount);
        int avgSpace = totalSpace/(wordCount-1);
        int remainSpace = totalSpace%(wordCount-1);

        for(int i=0;i<wordCount-1;++i) {
            res.append(tmpLine.get(i));
            if(remainSpace>0) {
                appendSpaces(res, avgSpace+1);
                remainSpace--;
            } else {
                appendSpaces(res, avgSpace);
            }
        }
        res.append(tmpLine.get(wordCount-1));
        return res.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0) return res;

        int tmpLen = 0;
        List<String> tmpLine = new ArrayList<String>();
        int i = 0;
        boolean lastLine;
        while(i<words.length) {
            String word = words[i];
            // fill in a line
            while(tmpLen + word.length() <= maxWidth && i<words.length) {
                tmpLen += word.length() + 1; // each word should be at least one space character behind
                tmpLine.add(word);
                i++;
                if(i== words.length) break;
                word = words[i];

            }
            // if the last line
            lastLine = (i == words.length);
            // ajust a line
            String line = adjustLine(tmpLine, tmpLen, maxWidth, lastLine);
            res.add(line);
            tmpLen = 0;
            tmpLine.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        LC_68_AdjustText inst = new LC_68_AdjustText();
        String[] words = new String[]{"aga", "gagag", "agagh", "agag", "aa", "aggagahhahah", "aag", "aga"};
        int maxWidth = 18;
        List<String> res = inst.fullJustify(words, maxWidth);
        for(String str:res) {
            System.out.println(str);
        }
        StringTokenizer st = new StringTokenizer("");
    }
}
