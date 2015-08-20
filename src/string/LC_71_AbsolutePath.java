package string;

import java.util.*;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 * Created by xingyun on 15/7/31.
 */
public class LC_71_AbsolutePath {

    public String simplifyPath(String path) {

        List<String> pathBuf = new ArrayList<String>();
        // tokenize path with demli "/"
        int i = 0;
        while(i<path.length()) {
            while(i<path.length() && path.charAt(i) == '/') i++;
            StringBuilder sb = new StringBuilder();
            while(i<path.length() && path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                i++;
            }
            if(sb.length() == 0) continue;
            String token = sb.toString();

            // ignore .
            if(token.equals(".")) continue;
            // if "..", remove last dir
            if(token.equals("..")) {
                if(pathBuf.size() >0) pathBuf.remove(pathBuf.size()-1);
            } else {
                pathBuf.add(token);
            }
        }
        if(pathBuf.size() == 0) return "/";
        StringBuilder sb = new StringBuilder("");
        for(String str:pathBuf) {
            sb.append('/');
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_71_AbsolutePath inst = new LC_71_AbsolutePath();
        System.out.println(inst.simplifyPath("/../a/./b/"));


    }
}
