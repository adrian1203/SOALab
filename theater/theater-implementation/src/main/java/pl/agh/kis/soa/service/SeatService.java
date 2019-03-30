package pl.agh.kis.soa.ejb3.server.impl.service;

import pl.agh.kis.soa.ejb3.server.impl.domain.Seat;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class SeatService {

    @EJB
    TheaterManager theaterManager;

    public List<Seat> getAvailableSeat(){
        return theaterManager.getSeatList().stream().filter(seat -> !seat.getBooked()).collect(Collectors.toList());
    }

    public Boolean checkIfAvailable(Integer seatId){
        return !theaterManager.getSeatList().get(seatId).getBooked();
    }


}
