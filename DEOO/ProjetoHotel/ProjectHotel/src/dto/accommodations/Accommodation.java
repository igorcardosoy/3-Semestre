package dto.accommodations;

import dto.payment.CreditCard;
import dto.persons.Escort;
import dto.persons.Guest;

import java.time.LocalDateTime;
import java.util.List;

public class Accommodation {

    private final int number;
    private final int floor;
    private final TypesOfAccommodation type;
    private boolean isOccupied;


    private boolean isReserved;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Guest host;
    private CreditCard hostCreditCard;
    private double discount;
    private List<Escort> escorts;
    private double penaltyPrice;


    public Accommodation(int number, int floor, TypesOfAccommodation type) {
        this.number = number;
        this.floor = floor;
        this.type = type;
        this.isOccupied = false;
    }

    public Accommodation(Accommodation accommodation) {
        this.number = accommodation.getNumber();
        this.floor = accommodation.getFloor();
        this.type = accommodation.getType();
        this.isOccupied = accommodation.isOccupied();
    }

    public void reserveAccommodation(Guest host, CreditCard hostCreditCard, LocalDateTime checkIn, LocalDateTime checkOut, double discount, List<Escort> escorts) {
        this.isReserved = true;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.host = host;
        this.hostCreditCard = hostCreditCard;
        this.discount = discount;
        this.escorts = escorts;
    }

    public Accommodation

    public void occupyAccommodation() {
        isReserved = false;
        this.isOccupied = true;
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public TypesOfAccommodation getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }


}
