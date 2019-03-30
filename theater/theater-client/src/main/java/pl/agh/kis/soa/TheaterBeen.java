package pl.agh.kis.soa;


import pl.agh.kis.soa.ejb3.server.impl.domain.Seat;
import pl.agh.kis.soa.ejb3.server.impl.exceptions.NotEnoughMoneyException;
import pl.agh.kis.soa.ejb3.server.impl.exceptions.SeatAlreadyReservatedException;
import pl.agh.kis.soa.ejb3.server.impl.service.PurchaseService;
import pl.agh.kis.soa.ejb3.server.impl.service.SeatService;
import pl.agh.kis.soa.ejb3.server.impl.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name = "TheaterBeen")
@SessionScoped
public class TheaterBeen {

    private final static Logger LOGGER = Logger.getLogger(TheaterBeen.class.getName());

    private List<Seat> choosedSeat= new ArrayList<>();

    private HtmlSelectManyCheckbox htmlSelectManyCheckbox;

    private boolean displayed=false;

    private boolean notEnoughtMany;

    private boolean alreadyBooked;




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
            return "/rezerwacja.xhtml";
        }else return "/index.xhtml";
    }
    public List<Seat> getAvailableSeat(){
        return seatService.getAvailableSeat();
    }

    public void displayChoosedSeat(){
//        LOGGER.info("displayChoosedSeat");
//        if(displayed==false){
//            displayed=true;
//            return;
//        }
//        if(choosedSeat.size()>0){
//           this.displayed=true;
//            LOGGER.info("treu");
//        }else{
//           this.displayed=false;
//            LOGGER.info("false");
//        }
    }

    public String generatePayment(){

        try{for(Seat seat :choosedSeat){
            LOGGER.info(seat.toString());
            this.purchaseService.bookSeat(seat.getId(),userService.getLogedUser().getId());
        }}
        catch (NotEnoughMoneyException e){
            this.notEnoughtMany=true;
            return "/podsumowanie.xhtml";
        }
        catch (SeatAlreadyReservatedException e){
            this.alreadyBooked=true;
            return "/podsumowanie.xhtml";
        }
        catch (Exception e){
            this.alreadyBooked=true;
            return "/podsumowanie.xhtml";
        }
        return "/podsumowanie.xhtml";

    }

    public Integer getAllAmount(){
        Integer amout = 0;
        for(Seat seat : choosedSeat){
            amout+=seat.getPrice();
        }
        return amout;
    }

    public String logOut(){
        userService.logOut();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml";
    }

    public String goToReservation(){
        choosedSeat=null;
        choosedSeat=new ArrayList<>();
        return "/rezerwacja.xhmtl";
    }

    public boolean isNotEnoughtMany() {
        return notEnoughtMany;
    }

    public void setNotEnoughtMany(boolean notEnoughtMany) {
        this.notEnoughtMany = notEnoughtMany;
    }

    public boolean isAlreadyBooked() {
        return alreadyBooked;
    }

    public void setAlreadyBooked(boolean alreadyBooked) {
        this.alreadyBooked = alreadyBooked;
    }
}
