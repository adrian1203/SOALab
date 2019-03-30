package pl.agh.kis.soa.ejb3.server.impl.service;


import pl.agh.kis.soa.ejb3.server.impl.domain.Seat;
import pl.agh.kis.soa.ejb3.server.impl.domain.User;
import pl.agh.kis.soa.ejb3.server.impl.exceptions.NotEnoughMoneyException;
import pl.agh.kis.soa.ejb3.server.impl.exceptions.SeatAlreadyReservatedException;

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
