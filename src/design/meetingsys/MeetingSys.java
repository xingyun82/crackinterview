package design.meetingsys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yunxing on 6/28/16.
 */
public class MeetingSys {

    public List<MeetingRoomSlot> getMeetingRoomSlots(int roomId, Date day) {
        return null;
    }

    public List<MeetingRoom> getMeetingRooms(int buildingId) {
        return null;
    }

    public boolean canBeScheduled(MeetingRoom room, int persons, Date day, Date startTime, Date endTime) {
        List<MeetingRoomSlot> roomSlots = getMeetingRoomSlots(room.id, day);
        boolean shouldCheckSlot = false;
        for(MeetingRoomSlot slot: roomSlots) {
            if(startTime.compareTo(slot.startDate) >= 0 && startTime.compareTo(slot.endDate) < 0) {
                shouldCheckSlot = true;
            }
            if(shouldCheckSlot && slot.booked) return false;
            if(endTime.compareTo(slot.startDate) >0 && endTime.compareTo(slot.endDate) <= 0) {
                return true;
            }
        }
        return false;
    }

    public List<MeetingRoom> scheduleMeeting(int buildingId, int persons, Date day, Date startTime, Date endTime) {
        List<MeetingRoom> roomCandidates = new ArrayList<>();
        List<MeetingRoom> rooms = getMeetingRooms(buildingId);
        for(MeetingRoom room: rooms) {
            if(canBeScheduled(room, persons, day, startTime, endTime)) {
                roomCandidates.add(room);
            }
        }
        return roomCandidates;
    }


}
