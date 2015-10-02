package design.elevator;

/**
 * Created by xingyun on 9/30/15.
 */

public class Controller {

    Elevator elevator;

    public Controller(Elevator elevator) {
        this.elevator = elevator;
    }

    public void processCommand(Command command) {
        switch(command.type) {
            case UP: elevator.addStopFloor(command.floor, 1); break;
            case DOWN: elevator.addStopFloor(command.floor, 2); break;
            case OPEN: elevator.openDoor(); break;
            case CLOSE: elevator.closeDoor(); break;
            case FLOOR: elevator.addStopFloor(command.floor); break;
        }
    }

}
