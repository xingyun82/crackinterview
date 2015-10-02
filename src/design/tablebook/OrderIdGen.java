package design.tablebook;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xingyun on 9/17/15.
 */
public class OrderIdGen {

    private static AtomicInteger swiftId;

    public static int getNextId() {
        return swiftId.addAndGet(1);
    }

}
