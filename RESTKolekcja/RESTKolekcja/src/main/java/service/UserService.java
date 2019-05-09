package service;

import domain.RentalUser;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;
    public UserService() {
        this.userRepository=new UserRepository();
    }

    public List<RentalUser> getAllUser(){
        return this.userRepository.getAllUsers();
    }
    public RentalUser getUserById(Long id){
        return this.userRepository.findUserById(id);
    }
    public void deleteUser(Long id){
        this.userRepository.deleteUser(id);
    }
    public void updateUser(RentalUser rentalUser){
        this.userRepository.updateBook(rentalUser);
    }
    public void createUser(RentalUser rentalUser){
        this.userRepository.createUser(rentalUser);
    }
}
