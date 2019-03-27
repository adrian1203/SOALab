package soa.domain;

public class Seat {
    private Integer id;
    private Integer number;
    private SeatType seatType;
    private Integer price;
    private Boolean booked;

    public Seat(Integer id, Integer number, SeatType seatType, Integer price) {
        this.id = id;
        this.number = number;
        this.seatType = seatType;
        this.price = price;
        this.booked=false;
    }
    public Seat(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }
}
