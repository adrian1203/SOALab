package soa.repository;

import soa.domain.Seat;
import soa.domain.SeatType;

import java.util.LinkedList;
import java.util.List;

public class SeatRepository {

    public List<Seat> getSeets() {
        List<Seat> seatList = new LinkedList<>();
        int counter = 0;
        while (seatList.size() < 20) {
                seatList.add(new Seat(counter, counter+1, SeatType.BALKON, 50));
                counter++;
        }
        while (seatList.size() < 40) {
            seatList.add(new Seat(counter, counter+1, SeatType.LOZA, 120));
            counter++;
        }
        while (seatList.size() < 52) {
            seatList.add(new Seat(counter, counter+1, SeatType.WIDOWNIA, 80));
            counter++;
        }

        return seatList;
    }


}
