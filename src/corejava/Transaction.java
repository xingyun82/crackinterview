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
 count(c); --> 2
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


class Database<K, V> {

    Map<K, V> data = new HashMap<K, V>();

    public V get(K key) {
        return data.get(key);
    }

    public void set(K key, V val) {
        data.put(key, val);
    }

    public void delete(K key) {
        data.remove(key);
    }

    public List<K> getKeys(V val) {
        List<K> keys = new ArrayList<K>();
        for(Map.Entry<K, V> entry: data.entrySet()) {
            if(entry.getValue().equals(val)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public int count(V val) {
        int count = 0;
        for(Map.Entry<K, V> entry: data.entrySet()) {
            if(entry.getValue().equals(val)) count++;
        }
        return count;
    }

}


public class Transaction<K, V> {


    class CacheNode<V> {
        V val;
        int type; // 0 load, 1 write, 2 delete
        public CacheNode(V val, int type) { this.val = val; this.type = type; }
    }

    boolean startTrans = false;

    Map<K, CacheNode<V>> cache = new HashMap<K, CacheNode<V>>();
    Database<K, V> db = new Database<K, V>();

    public void set(K key, V val) {
        if(startTrans) {
            if(!cache.containsKey(key)) {
                cache.put(key, new CacheNode<V>(val, 1));
            } else {
                cache.get(key).val = val;
                cache.get(key).type = 1;
            }
        } else {
            db.set(key, val);
        }
    }

    public V get(K key) {
        if(startTrans) {
            CacheNode<V> node = cache.get(key);
            if(node == null) {
                return db.get(key);
            } else {
                if(node.type == 2) return null;
                return node.val;
            }
        } else {
            return db.get(key);
        }
    }

    public int count(V val) {
        int count = 0;
        List<K> keys = db.getKeys(val);
        for(K key:keys) {
            if(!cache.containsKey(key)) {
                count++;
            }
        }

        for(K key: cache.keySet()) {
            if(cache.get(key).val != null && cache.get(key).val.equals(val)) {
                count++;
            }
        }
        return count;
    }

    public void delete(K key) {
        if(startTrans) {
            if(!cache.containsKey(key)) {
                cache.put(key, new CacheNode<V>(null, 2));
            } else {
                cache.get(key).type = 2;
            }
        } else {
            db.delete(key);
        }
    }

    public void begin_trans() {
        startTrans = true;
    }

    public void commit() {
        for(K key: cache.keySet()) {
            if(cache.get(key).type == 1) {
                db.set(key, cache.get(key).val);
            } else if(cache.get(key).type == 2) {
                db.delete(key);
            }
        }
        cache.clear();
    }

    public void rollback() {
        cache.clear();
    }

    public static void main(String[] args) {
        Transaction<Integer, Character> inst = new Transaction<Integer, Character>();
        inst.set(1, 'a');
        inst.set(2, 'b');
        inst.set(3, 'c');
        System.out.println(inst.get(3));
        inst.set(4, 'c');
        System.out.println(inst.count('c'));
        inst.delete(2);
        System.out.println(inst.get(2));
        inst.begin_trans();
        inst.set(2, 'd');
        System.out.println(inst.get(2));
        inst.commit();
        System.out.println(inst.get(2));
        inst.begin_trans();
        inst.set(5, 'e');
        inst.set(6, 'e');
        System.out.println(inst.count('e'));
        inst.rollback();
        System.out.println(inst.count('e'));

    }

}
