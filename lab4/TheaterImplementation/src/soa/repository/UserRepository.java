package soa.repository;

import soa.domain.User;

import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    public List<User> getAllUser() {

        List<User> seatList = new LinkedList<>();
        seatList.add(new User(0,"Marcin", "admin3", "admin3",25500));
        seatList.add(new User(1,"Adrian", "admin", "admin",2550));
        seatList.add(new User(2,"Jakub", "admin1", "admin1",2000));
        seatList.add(new User(3,"Kamil", "admin2", "admin2",2550));



        return seatList;
    }

}
