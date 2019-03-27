package soa.service;


import soa.domain.Seat;
import soa.domain.User;
import soa.exceptions.NotEnoughMoneyException;
import soa.exceptions.SeatAlreadyReservatedException;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class PurchaseService {
    @EJB
    TheaterManager theaterManager;
    public boolean bookSeat(Integer seatId, Integer userId) throws SeatAlreadyReservatedException, NotEnoughMoneyException {
        Seat seat =theaterManager.getSeatList().get(seatId);
        if(seat.getBooked()){
            throw new SeatAlreadyReservatedException("To miejsce zostało już zajętę");
        }
        User user=theaterManager.getUsers().get(userId);
        if(seat.getPrice()>user.getMoney()){
            throw new NotEnoughMoneyException("Brak wystarczającej kwoty na kącie");
        }
        theaterManager.buyTicket(seatId,userId);
        return true;
    }
}
