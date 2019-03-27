package soa;


import soa.domain.Seat;
import soa.domain.User;
import soa.service.PurchaseService;
import soa.service.SeatService;
import soa.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name = "TheaterBeen")
@SessionScoped
public class TheaterBeen {

    private final static Logger LOGGER = Logger.getLogger(TheaterBeen.class.getName());

    private List<Seat> choosedSeat= new ArrayList<>();

    private HtmlSelectManyCheckbox htmlSelectManyCheckbox;

    private boolean displayed;




    @EJB
    private UserService userService;

    @EJB
    private SeatService seatService;

    @EJB
    private PurchaseService purchaseService;

    public TheaterBeen() {
    }

    public HtmlSelectManyCheckbox getHtmlSelectManyCheckbox() {
        return htmlSelectManyCheckbox;
    }

    public void setHtmlSelectManyCheckbox(HtmlSelectManyCheckbox htmlSelectManyCheckbox) {
        this.htmlSelectManyCheckbox = htmlSelectManyCheckbox;
    }

    public List<Seat> getChoosedSeat() {
        return choosedSeat;
    }

    public void setChoosedSeat(List<Seat> choosedSeat) {
        this.choosedSeat = choosedSeat;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }

    public String logIn(String loging, String password){
        LOGGER.info("działąmdmdmddd");
        System.out.println("działm");
        LOGGER.info(userService.logIn(loging,password).toString());

        if(userService.logIn(loging,password)){
            return "LOG";
        }else return "ERROR";
    }
    public List<Seat> getAvailableSeat(){
        return seatService.getAvailableSeat();
    }

    public void displayChoosedSeat(){
       if(choosedSeat.size()>0){
           this.displayed=true;
       }else{
           this.displayed=false;
       }
    }

    public String generatePayment()throws Exception{
        for(Seat seat :choosedSeat){
            LOGGER.info(seat.toString());
            this.purchaseService.bookSeat(seat.getId(),userService.getLogedUser().getId());
        }
        return "PODSUMOWANIE";

    }

    public Integer getAllAmount(){
        Integer amout = 0;
        for(Seat seat : choosedSeat){
            amout+=seat.getPrice();
        }
        return amout;
    }
}
