package tablebook;

import java.util.*;
/**
 * Created by xingyun on 9/17/15.
 */
public class Restaurant {

    private Vector<Table> tables = new Vector<Table>();
    private Hashtable<Integer, Date> tableStatusMap = new Hashtable<Integer, Date>();
    private String name;



    private static Restaurant inst = new Restaurant("ABC");

    public static Restaurant getInstance() {
        return inst;
    }

    private void initialTables() {
        for(int i=0; i<10; ++i) {
            Table table = new Table();
            table.setId(i+1);
            Random r = new Random();
            int rv = r.nextInt(2);
            if(rv <1) {
                table.setNumSeats(4);
            } else {
                table.setNumSeats(10);
            }
            tables.add(table);
        }
    }

    private Restaurant(String name) {
        this.name = name;
        initialTables();
    }

    public void clearTable(Integer tableId) {
        tableStatusMap.remove(tableId);
    }


    public List<Integer> checkTableAvail(TableBook tb) {
        // table.seatnums > tb.persons
        // table is not booked
        List<Integer> res = new ArrayList<Integer>();
        for(Table table:tables) {
            if(table.getNumSeats() > tb.getPersonNum()
                    && !tableStatusMap.containsKey(table.getId())) {
                res.add(table.getId());
            }
        }
        return res;
    }

    public TableOrder bookTable(int tableId, TableBook tb) {
        TableOrder order = new TableOrder();
        Date now = new Date();
        tableStatusMap.put(tableId, now);
        order.setBookTime(now);
        order.setContactName(tb.getContactName());
        order.setContactPhone(tb.getContactPhone());
        order.setStartTime(tb.getStartTime());
        order.setTableId(tableId);
        order.setOrderId(OrderIdGen.getNextId());
        return order;
    }


    public static void main(String[] args) {
        Restaurant inst = Restaurant.getInstance();
        TableBook tb = new TableBook();
        tb.setStartTime(new Date());
        tb.setPersonNum(5);
        tb.setContactName("yun");
        tb.setContactPhone("4154307184");
        List<Integer> tableIds = inst.checkTableAvail(tb);
        if(tableIds.isEmpty()) {
            System.out.println("Sorry, can't reserve!");
        } else {
            System.out.println("There are following tables for you:");
            for(int i:tableIds) {
                System.out.print(i+" ");
            }
        }
        Random r = new Random();
        int tableId = r.nextInt(tableIds.size());
        inst.bookTable(tableId, tb);
    }


}
