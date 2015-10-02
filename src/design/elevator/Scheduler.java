package design.elevator;

/**
 * Created by xingyun on 9/30/15.
 */
public class Scheduler {

    Elevator elevator;

    public Scheduler(Elevator elevator) {
        this.elevator = elevator;
    }

    public void run() {
        while(true) {
            try {
                elevator.moveToNext();
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
