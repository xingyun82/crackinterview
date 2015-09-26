package corejava;

import java.util.Date;

/**
 *
 * 新鲜出炉的dropbox电话面经， 叫我写个计数函数，返回5分钟内hit()被运行了几次.

 两个function;

 void hit()

 long getHits() //返回五分钟内hit了几次

 * Created by xingyun on 9/24/15.
 */
public class HitCounter {

    final static int BUFFER_SIZE = 300;
    long last = 0;
    int[] hitcount = new int[BUFFER_SIZE];
    long lastTime = System.currentTimeMillis();
    long total = 0;

    public void hit() {
        long now = System.currentTimeMillis();
        long delta = (now - lastTime)/1000;
        long cur = last+delta;

        for(long i=last+1; i<=cur && i<=last+BUFFER_SIZE; i++) {
            total -= hitcount[(int)(i%BUFFER_SIZE)];
            hitcount[(int)(i%BUFFER_SIZE)] = 0;
        }

        hitcount[(int)(cur%BUFFER_SIZE)]++;
        total++;
        last = cur;
        lastTime = now;
    }

    public long getHits() {
        return total;
    }
}
