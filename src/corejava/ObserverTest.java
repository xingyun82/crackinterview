package corejava;

/**
 * Created by xingyun on 9/17/15.
 */

import java.util.Observable;
import java.util.Observer;

class MessageBoard extends Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }
}

class Student implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println("Message board changed: " + arg);
    }
}

public class ObserverTest {

    public static void main(String[] args) {
        MessageBoard board = new MessageBoard();
        Student bob = new Student();
        Student joe = new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");
    }

}
