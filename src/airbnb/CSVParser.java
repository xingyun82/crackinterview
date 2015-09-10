package airbnb;

import java.util.*;
/**
 * Created by xingyun on 15/8/28.
 */
public class CSVParser {


    private List<String> splitCSV(String str) {

        List<String> res = new ArrayList<String>();
        int quoraCount = 0;
        int doubleQuoraCount = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); ++i) {
            char c = str.charAt(i);
            if(c == ',') {
                if(quoraCount == 0 && doubleQuoraCount == 0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(',');
                }
            } else if(c == '"') {
                // decide if the character is quora or double quora
                // quora
                if(i+1<str.length() && str.charAt(i+1) != '"') {
                    if(quoraCount == 0) quoraCount++;
                    else quoraCount--;
                }
                // double quora
                if(i+1<str.length() && str.charAt(i+1) == '"') {
                    if(doubleQuoraCount == 0) doubleQuoraCount++;
                    else doubleQuoraCount--;
                    sb.append('"');
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        res.add(sb.toString());
        return res;
    }

    public static void main(String[] args) {
        String str = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
        //String str = "aga,,gaga";
        CSVParser inst = new CSVParser();
        List<String> res = inst.splitCSV(str);
        for(int i=0; i<res.size()-1; ++i) {
            System.out.print(res.get(i) + "|");
        }
        System.out.println(res.get(res.size()-1));



    }
}
