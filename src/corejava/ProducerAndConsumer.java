package corejava;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * there are three ways to solve producer-consumer problem in java:
 * 1. synchronized
 * 2. lock/condition
 * 3. semaphore
 *
 * Created by xingyun on 15/9/5.
 */

class Data {
    public static Lock lock = new ReentrantLock();
    public static Condition notEmpty = lock.newCondition();
    public static Condition notFull  = lock.newCondition();

    public static Stack<Integer> buffer = new Stack<Integer>();
}

class Producer extends Thread {

    private int id;

    public Producer(int id) {
        this.id = id;
    }

    public void run()  {
        while(true) {
            Data.lock.lock();
            try {
                // 这里一定要用while
                // 因为生产者被唤醒后，这时又可能有别的生产者填满了buffer
                while (Data.buffer.size() == 10) {
                    try {
                        System.out.println("P[" + id + "] buffer is full, start waiting...");
                        Data.notFull.await();
                        System.out.println("P[" + id + "] wakeup");

                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("P[" + id + "] produce");
                Data.buffer.push(1);
                System.out.println("P[" + id + "] size=" + Data.buffer.size());
                Data.notEmpty.signal();
            } finally {
                Data.lock.unlock();
            }

            try {
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer extends Thread {

    private int id;

    public Consumer(int id) {
        this.id = id;
    }
    public void run() {
        while(true) {
            Data.lock.lock();
            try {
                // 这里一定要用while
                // 因为消费者被唤醒后，这时又可能有别的消费者清空了buffer
                while (Data.buffer.size() == 0) {
                    try {
                        System.out.println("C[" + id + "] buffer is null, start waiting...");
                        Data.notEmpty.await();
                        System.out.println("C[" + id + "] wake up");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("C[" + id + "] consume");
                Data.buffer.pop();
                System.out.println("C[" + id + "] size=" + Data.buffer.size());
                Data.notFull.signal();
            } finally {
                Data.lock.unlock();
            }


            try {
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

public class ProducerAndConsumer {

    public static void main(String[] args) {
        for(int i=0; i<2; ++i) {
            Producer p = new Producer(i+1);
            p.start();
        }
        for(int i=0; i<5; ++i) {
            Consumer c = new Consumer(i+1);
            c.start();
        }
    }


}
