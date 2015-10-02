package design.parkinglot;

/**
 * Created by xingyun on 10/1/15.
 */
public class Parkinglot {

    int capacity;
    int count;

    public boolean canParking() {
        return count < capacity;
    }

    public void carIn() {
        if(count < capacity) {
            count++;
        }
    }

    public void carOut() {
        if(count > 0) {
            count--;
        }
    }


}
