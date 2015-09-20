package tablebook;


import java.util.*;
/**
 * Created by xingyun on 9/17/15.
 */


public class RestaurantServiceThread extends Thread {

    public void run() {
        TableBook tb = new TableBook();
        tb.setStartTime(new Date());
        Random r = new Random();
        tb.setPersonNum(r.nextInt(10) + 1);
        tb.setContactName("Yun");
        tb.setContactPhone("415.430.7184");
        List<Integer> tableIds = Restaurant.getInstance().checkTableAvail(tb);
        int tableId = r.nextInt(tableIds.size());
        TableOrder order = Restaurant.getInstance().bookTable(tableId, tb);
        if(order != null) {
            System.out.println("book success!");
            System.out.println(order.toString());
        }
        // persist table order
    }

    public static void main(String[] args) {
        for(int i=0; i<10; ++i) {
            RestaurantServiceThread thread = new RestaurantServiceThread();
            thread.start();
        }
    }

}
