package parking;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Lot {

    PriorityQueue<ParkingSpace> handicapParkingSpaceQueue;
    PriorityQueue<ParkingSpace> normalParkingSpaceQueue;
    HashMap<String, ParkingSpace> occupiedSpace;

    public Lot(int noHandicapParking, int totalNoParking) {
        this.occupiedSpace = new HashMap<>();
        int num = 0;
        Comparator<ParkingSpace> comparator = ((a1, a2) -> a1.num - a2.num);
        handicapParkingSpaceQueue = new PriorityQueue<>(noHandicapParking, comparator);
        normalParkingSpaceQueue = new PriorityQueue<>(totalNoParking - noHandicapParking, comparator);
        for (int i = 0; i < noHandicapParking; i++) {
            handicapParkingSpaceQueue.add(new ParkingSpace(num++, true));
        }
        for (int i = noHandicapParking; i < totalNoParking; i++) {
            normalParkingSpaceQueue.add(new ParkingSpace(num++, false));
        }
    }

    //take the first available space and park
    public boolean park(Car c, boolean isHandicap) {
        if (isHandicap) { //get the first handicap space if possible
            if (!handicapParkingSpaceQueue.isEmpty()) {
                ParkingSpace takenSpace = handicapParkingSpaceQueue.remove();
                occupiedSpace.put(c.getPlate(), takenSpace);
                takenSpace.take();
                return true;
            }
        }
        if (!normalParkingSpaceQueue.isEmpty()) {
            ParkingSpace takenSpace = normalParkingSpaceQueue.remove();
            occupiedSpace.put(c.getPlate(), takenSpace);
            takenSpace.take();
            return true;
        }
        return false;
    }

    //valte parking get the car for the customer
    public long unpark(Car c) {
        if (!occupiedSpace.containsKey(c.getPlate())) {
            return -1; //no such car in this lot
        }
        ParkingSpace freeSpace = occupiedSpace.remove(c.getPlate());
        if (freeSpace.type == ParkingSpace.TYPE.HANDICAP) {
            handicapParkingSpaceQueue.add(freeSpace);
        } else {
            normalParkingSpaceQueue.add(freeSpace);
        }
        return freeSpace.leave();
    }

    public boolean isNormalFull() {
        return normalParkingSpaceQueue.isEmpty();
    }

    public boolean isHandicapFull() {
        return handicapParkingSpaceQueue.isEmpty();
    }

    public static void main(String[] args) {
        Car c1 = new Car("1111"); //handicap
        Car c2 = new Car("2222"); // normal
        Car c3 = new Car("3333"); // normal
        Car c4 = new Car("4444"); // normal
        Lot lot1 = new Lot(2, 3);
        lot1.park(c1, true);
        lot1.park(c2, false);
        lot1.park(c3, false);
        lot1.unpark(c1);
        lot1.park(c4, false);
        lot1.unpark(c2);
        lot1.park(c3, false);
    }
}
