package hashtable;

/**
 * similar to huffman encoding
 * suppose there is a string:  abbcaa
 * then, the frequency table is:
 * a 3
 * b 2
 * c 1
 * then, the encode method is:
 * a 1
 * b 01
 * c 001
 * in this way, the input str can be encoded as: 1010100111
 * Created by xingyun on 10/1/15.
 */
public class Snapchat_Encoding {

    // idea:
    // 1. get the frequency map of each character
    // 2. sort the character-frequency object by frequency, using PriorityQueue
    // 3. pop character-frequency object from the PriorityQueue, and construct a encoding map
    // 4. loop the characters of input string, and replace each character with encoding str
}
