package string;


import java.util.*;
/**
 *
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:
 For the return value, each inner list's elements must follow the lexicographic order.
 All inputs will be in lower-case.
 Update (2015-08-09):
 The signature of the function had been updated to return list<list<string>> instead of list<string>, as suggested here. If you still see your function signature return a list<string>, please click the reload button  to reset your code definition.
 * Created by xingyun on 15/8/20.
 */
public class LC_49_GroupAnagrams {

    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<Integer>> hashmap =
                new HashMap<String, ArrayList<Integer>>();
        ArrayList<String> res = new ArrayList<String>();
        // build a hash table, with the "unique" string form as the key
        for(int i=0; i<strs.length; ++i){
            char [] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            ArrayList<Integer> value = hashmap.get(key);
            if(value == null){
                value = new ArrayList<Integer>();
                value.add(i);
                hashmap.put(key, value);
            }else{
                value.add(i);
            }
        }

        // extract anagrams from the hash table.
        Iterator<String> iter = hashmap.keySet().iterator();
        while(iter.hasNext()){
            ArrayList<Integer> indexList =
                    (ArrayList<Integer>) hashmap.get(iter.next());
            if(indexList.size() > 1){
                for(Integer i : indexList){
                    res.add(strs[i]);
                }
            }
        }

        return res;
    }
}
