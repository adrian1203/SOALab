package soa.service;


import soa.domain.Seat;
import soa.domain.User;
import soa.repository.SeatRepository;
import soa.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;
import java.util.logging.Logger;

@Singleton
@Startup
public class TheaterManager {

    private final static Logger logger = Logger.getLogger(TheaterManager.class.getName());
    private List<Seat> seats;
    private List<User> users;


    @PostConstruct
    public void setupTheater(){
        System.out.println("STARUP");
        logger.config("Inicjuje");
        UserRepository userRepository = new UserRepository();
        users = userRepository.getAllUser();
        SeatRepository seatRepository = new SeatRepository();
        seats = seatRepository.getSeets();
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Lock(LockType.READ)
    public Integer getSeatPrice(Integer seatId){
        return getSeatList().get(seatId).getPrice();
    }

    @Lock(LockType.WRITE)
    public void buyTicket(Integer seatId, Integer userId){
        Seat seat = getSeatList().get(seatId);
        seat.setBooked(true);
        User user = getUsers().get(userId);
        user.setMoney(user.getMoney()-seat.getPrice());

    }
    @Lock(LockType.READ)
    public List<Seat> getSeatList(){
        return this.seats;
    }
}
