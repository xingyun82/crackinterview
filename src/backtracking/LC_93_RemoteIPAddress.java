package backtracking;


import java.util.*;
/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 * Created by xingyun on 15/8/19.
 */
public class LC_93_RemoteIPAddress {

    // main idea: backtracking
    // should be note that
    // 1. there should be 4 segments
    // 2. each segment of IP should be between 0 and 255
    private void backtrack(List<String> res, List<String> path, int cur, String s) {
        if((path.size() >= 4 && cur < s.length()) || (path.size() < 4 && cur >= s.length())) return;
        if(path.size() == 4 && cur == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<path.size(); ++i) {
                if(i!=0)sb.append('.');
                sb.append(path.get(i));
            }
            res.add(sb.toString());
            return;
        }
        // next possbile seg length list
        List<Integer> nxtLens = new ArrayList<Integer>();
        if(s.charAt(cur) == '0') { nxtLens.add(1); }
        else if(s.charAt(cur) > '2') { nxtLens.add(1); nxtLens.add(2); }
        else { nxtLens.add(1); nxtLens.add(2); nxtLens.add(3); }

        for(int i:nxtLens) {
            if(cur+i>s.length()) continue;
            String seg = s.substring(cur, cur+i);
            if(i==3) {
                int segVal = Integer.valueOf(seg);
                if(segVal > 255) continue;
            }

            path.add(seg);
            backtrack(res, path, cur+i, s);
            path.remove(path.size()-1);
        }

    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        List<String> path = new ArrayList<String>();
        backtrack(res, path, 0, s);
        return res;
    }
}
