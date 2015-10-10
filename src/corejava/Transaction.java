package corejava;

import java.util.*;
/**
 *
 * 一个带有transaction功
 能的数据存储，要求：
 a. set 存key-value pair
 b. get 给定key，返回value
 c. count 某一个value出现的次数.
 d. delete 删掉某个key的value
 e. begin transaction 开始一个transaction.
 f. commit 将所有在transaction里的操作永久存入
 g. rollback 删掉最后一个transaction里的所有操作
 ex:
 set(1,a);
 set(2,b);
 set(3,c);
 get(3); --> 'c'
 set(4,c);
 count(4); --> 2
 delete(2);
 get(2); --> null
 begin;
 set(2, d);
 get(2); --> 'd'
 commit;
 get(2); --> 'd'
 begin;
 set(5,e);
 set(6,e);
 count(e); --> 2
 rollback;
 count(e); --> 0.


 * Created by xingyun on 10/9/15.
 */

class Database {

    public int read_from_db(int key) {
        return 0;
    }

    public void write_to_db(int key, int val) {

    }

    public void delete_from_db(int key) {

    }

    public int count_from_db(int val) {
        return 0;
    }

}
public class Transaction {

    class BufferedNode {
        int val;
        int type; // 0 load, 1 write, 2 delete
        public BufferedNode(int val, int type) { this.val = val; this.type = type; }
    }


    Map<Integer, Integer> bufferedValueCount = new HashMap<Integer, Integer>();
    Map<Integer, BufferedNode> bufferedStatus = new HashMap<Integer, BufferedNode>();
    boolean startTrans = false;


    Database db = new Database();


    public void set(int key, int val) {
        if(startTrans) {
            bufferedStatus.put(key, new BufferedNode(val, 1));
            if(bufferedValueCount.containsKey(val)) {
                bufferedValueCount.put(val, bufferedValueCount.get(val)+1);
            } else {
                bufferedValueCount.put(val, 1);
            }
        } else {
            db.write_to_db(key, val);
        }
    }

    public Integer get(int key) {
        if(startTrans) {
            if(bufferedStatus.containsKey(key)) {
                BufferedNode node = bufferedStatus.get(key);
                if(node.type == 2) return null;
                return node.val;
            }
        }
        return db.read_from_db(key);
    }

    public int count(int val) {
        int dbcount = db.count_from_db(val);
        int cachecount = 0;
        if(bufferedValueCount.containsKey(val)) {
            cachecount = bufferedValueCount.get(val);
        }
        return dbcount + cachecount;
    }

    public void delete(int key) {
        if(startTrans) {
            Integer val = null;
            if(bufferedStatus.containsKey(key)) {
                val = bufferedStatus.get(key).val;
                bufferedStatus.get(key).type = 3;
                bufferedValueCount.put(val, bufferedValueCount.get(val)-1);
            } else {
                val = db.read_from_db(key);
                bufferedStatus.put(key, new BufferedNode(val, 3));
                if(bufferedValueCount.containsKey(val)) {
                    bufferedValueCount.put(val, bufferedValueCount.get(val)-1);
                } else {
                    bufferedValueCount.put(val, -1);
                }
            }
        } else {
            db.delete_from_db(key);
        }
    }

    public void begin_trans() throws Exception{
        if(startTrans) throw new Exception("transaction already started");
        startTrans = true;
    }

    public void commit() {
        for(int key:bufferedStatus.keySet()) {
            BufferedNode node = bufferedStatus.get(key);
            if(node.type == 2) {
                db.write_to_db(key, node.val);
            }
            else if(node.type == 3) {
                db.delete_from_db(key);
            }
        }
        bufferedStatus.clear();
        bufferedValueCount.clear();
    }

    public void rollback() {
        bufferedStatus.clear();
        bufferedValueCount.clear();
    }

}
