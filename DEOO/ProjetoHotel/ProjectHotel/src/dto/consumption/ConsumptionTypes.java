package dto.consumption;

public enum ConsumptionTypes {
    RESTAURANT("Restaurante"),
    LAUNDRY("Lavanderia"),
    MINI_BAR("Frigo-Bar");

    private final String value;

    ConsumptionTypes(String value) {
        this.value = value;
    }
}
