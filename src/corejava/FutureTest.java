package corejava;

import java.util.StringTokenizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 造死锁
 * Created by xingyun on 9/17/15.
 */

class DataLock {

    public static Lock locka = new ReentrantLock();
    public static Lock lockb = new ReentrantLock();
}

class ThreadA extends Thread {

    public void run() {

        DataLock.locka.lock();
        try {
            DataLock.lockb.lock();
            try {
                System.out.println("sleep in A");
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                DataLock.lockb.unlock();
            }
        } finally {
            DataLock.locka.unlock();
        }

    }
}

class ThreadB extends Thread {

    public void run() {
        DataLock.lockb.lock();
        try {
            DataLock.locka.lock();
            try {
                System.out.println("sleep in B");
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                DataLock.locka.unlock();
            }
        } finally {
            DataLock.lockb.unlock();
        }

    }
}


public class FutureTest {

    public static void main(String[] args) {
//        ThreadA threada = new ThreadA();
//        ThreadB threadb = new ThreadB();
//        threada.start();
//        threadb.start();

        StringTokenizer st = new StringTokenizer("aba,agag:aa,b,", ",:");
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }


    }

}




