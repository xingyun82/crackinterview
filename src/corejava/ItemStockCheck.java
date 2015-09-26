package corejava;

import java.util.*;

class Result {
    List<String> itemWantAvail = new ArrayList<String>();
    List<String> itemWantNotAvail = new ArrayList<String>();
}
/**
 * Created by xingyun on 9/25/15.
 */
public class ItemStockCheck {


    public Result dosth(List<String> itemWant, List<String> itemAvail) {

        Result res = new Result();
        if(itemWant == null || itemAvail == null) return res;

        Map<String, Integer> itemAvailMap = new HashMap<String,Integer>();
        for(String item:itemAvail) {
            if(itemAvailMap.containsKey(item)) {
                int count = itemAvailMap.get(item);
                itemAvailMap.put(item, count+1);
            } else {
                itemAvailMap.put(item, 1);
            }
        }

        for(String item:itemWant) {
            if(!itemAvailMap.containsKey(item)) {
                res.itemWantNotAvail.add(item);
            } else {
                int count = itemAvailMap.get(item);
                if(count > 0) {
                    res.itemWantAvail.add(item);
                    itemAvailMap.put(item, count-1);
                } else {
                    res.itemWantNotAvail.add(item);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> itemWant = new ArrayList<String>();
        itemWant.add("item1");
        itemWant.add("item3");
        itemWant.add("item3");
        itemWant.add("item5");
        List<String> itemAvail = new ArrayList<String>();
        itemAvail.add("item2");
        itemAvail.add("item3");
        itemAvail.add("item7");
        ItemStockCheck inst = new ItemStockCheck();
        Result res = inst.dosth(itemWant, itemAvail);
        System.out.println("item avail:");
        for(String item:res.itemWantAvail) {
            System.out.print(item + " ");
            System.out.println();
        }
        System.out.println("item not avail:");
        for(String item:res.itemWantNotAvail) {
            System.out.print(item + " ");
            System.out.println();
        }
    }

}
