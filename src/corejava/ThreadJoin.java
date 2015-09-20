package corejava;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by xingyun on 9/17/15.
 */
class ThreadToy extends Thread {

    private String name;

    public ThreadToy(String name) {
        this.name = name;
    }

    public void run() {
        try {
//            Random r = new Random();
//            int tc = r.nextInt(10);
//            java.lang.Thread.sleep(tc*1000);
            System.out.println("thread toy " + name + " run");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

public class ThreadJoin {

    public static void main(String[] args) throws Exception {


        ThreadToy toy1 = new ThreadToy("1");
        ThreadToy toy2 = new ThreadToy("2");
        ThreadToy toy3 = new ThreadToy("3");
        toy3.start();
        toy3.join();
        toy2.start();
        toy2.join();
        toy1.start();
        toy1.join();
//        toy2.join();
//        toy1.join();
//        toy3.join();

//        ExecutorService es = Executors.newFixedThreadPool(3);
//        es.execute(toy1);
//        es.execute(toy2);
//        es.execute(toy3);

//        es.shutdown();

    }

}
