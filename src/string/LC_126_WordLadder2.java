package string;

import java.util.*;

/**
 * Created by xingyun on 15/8/31.
 */
//class Node {
//    public String val;
//    public List<String> path = new ArrayList<String>();
//    public Node(String val) {this.val = val; }
//}

public class LC_126_WordLadder2 {

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        List<List<String>> res = new ArrayList<List<String>>();
        Queue<String> queue = new LinkedList<String>();
        // graph adjacent map
        Map<String, List<String>> pathMap = new HashMap<String, List<String>>();
        // min depth map (str => min depth)
        HashMap<String, Integer> depthMap = new HashMap<String, Integer>();
        dict.add(end);

        queue.offer(start);
        depthMap.put(start, 1);

        // global min depth
        int minDepth = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            String word = queue.poll();
            if(depthMap.get(word)+1 > minDepth) break;

            char[] chs = word.toCharArray();
            for(int i=0; i<chs.length; ++i) {
                for(char j='a'; j<'z'; j++) {

                    char[] newchs = word.toCharArray();
                    if(newchs[i] == j) continue;
                    newchs[i] = j;
                    String newWord = new String(newchs);

                    // if current depth large than min depth, ignore
                    if(depthMap.containsKey(newWord) && depthMap.get(newWord) < depthMap.get(word)+1) continue;

                    if(dict.contains(newWord)) {

                        if(newWord.equals(end)) {
                            minDepth = depthMap.get(word)+1;
                        }
                        // construct graph adjacent map
                        if(pathMap.containsKey(newWord)) {
                            // word exists, just add new edge
                            pathMap.get(newWord).add(word);
                        } else {
                            // new word
                            List<String> pre = new ArrayList<String>();
                            pre.add(word);
                            pathMap.put(newWord, pre);
                            // new word should be put in queue and depthmap
                            queue.offer(newWord);
                            depthMap.put(newWord, depthMap.get(word)+1);
                        }
                    }
                }
            }
        }
        // backtrack the path
        List<String> tmp = new ArrayList<String>();
        tmp.add(end);
        backtrack(res, tmp, end, pathMap);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> path, String cur, Map<String, List<String>> pathMap) {
        if(!pathMap.containsKey(cur)) {
            if(path.size()>1) {
                List<String> newPath = new ArrayList<String>(path);
                Collections.reverse(newPath);
                res.add(newPath);
            }
            return;
        }
        for(String next:pathMap.get(cur)) {
            path.add(next);
            backtrack(res, path, next, pathMap);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        String beginWord = "nape";
        String endWord = "mild";
        Set<String> wordDict = new HashSet<String>();
        wordDict.addAll(Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"));

        /*
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        */
        long start = System.currentTimeMillis();
        LC_126_WordLadder2 inst = new LC_126_WordLadder2();
        List<List<String>> res = inst.findLadders(beginWord, endWord, wordDict);
        long end = System.currentTimeMillis();

        for(List<String> ladders:res) {
            for(String ladder:ladders) {
                System.out.print(ladder + "->");
            }
            System.out.println();
        }
        System.out.println("time:" + (end-start));

    }

}