package dto.persons.Utils;

public final class Address {

    private final String number;
    private final String street;
    private final String neighborhood;
    private final String city;
    private final String state;
    private final String country;

    public Address(String number, String street, String neighborhood, String city, String state, String country) {
        this.number = number;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address(Address address) {
        this.number = address.getNumber();
        this.street = address.getStreet();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
