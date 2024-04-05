package dto.accommodations;

public class TypesOfAccommodation {
    private int id;
    private String description;
    private int quantity;
    private double price;
    private int AdultCapacity;
    private int ChildCapacity;

    public TypesOfAccommodation(int id, String description, int quantity, double price, int AdultCapacity, int ChildCapacity) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.AdultCapacity = AdultCapacity;
        this.ChildCapacity = ChildCapacity;
    }
}
