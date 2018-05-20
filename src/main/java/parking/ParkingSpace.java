package parking;

/**
 *
 * @author Omkar
 */
class ParkingSpace {

    enum TYPE {
        HANDICAP
    }
    int num;
    long timestamp;
    TYPE type;

    ParkingSpace(int i, boolean isHadicap) {
        num = i;
        if (isHadicap) {
            type = TYPE.HANDICAP;
        }
    }

    void take() {
        timestamp = System.currentTimeMillis();
    }

    long leave() {
        return System.currentTimeMillis() - timestamp;
    }

}
