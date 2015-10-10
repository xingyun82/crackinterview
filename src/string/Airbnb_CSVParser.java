package string;

import java.util.*;
/**
 * Created by xingyun on 15/8/28.
 */
public class Airbnb_CSVParser {


    private List<String> splitCSV(String str) {

        List<String> res = new ArrayList<String>();
        int quoteCount = 0;
        int doubleQuoteCount = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); ++i) {
            char c = str.charAt(i);
            if(c == ',') {
                if(quoteCount == 0 && doubleQuoteCount == 0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(',');
                }
            } else if(c == '"') {
                // decide if the character is quora or double quora
                // quora
                if(i+1<str.length() && str.charAt(i+1) != '"') {
                    if(quoteCount == 0) quoteCount++;
                    else quoteCount--;
                }
                // double quora
                if(i+1<str.length() && str.charAt(i+1) == '"') {
                    if(doubleQuoteCount == 0) doubleQuoteCount++;
                    else doubleQuoteCount--;
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
        Airbnb_CSVParser inst = new Airbnb_CSVParser();
        List<String> res = inst.splitCSV(str);
        for(int i=0; i<res.size()-1; ++i) {
            System.out.print(res.get(i) + "|");
        }
        System.out.println(res.get(res.size()-1));



    }
}
