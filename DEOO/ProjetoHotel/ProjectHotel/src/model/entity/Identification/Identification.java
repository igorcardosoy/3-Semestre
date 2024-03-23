package model.entity.Identification;

public enum Identification {
    RG("RG"),
    CPF("CPF"),
    PASSPORT("Passaporte");

    private final String value;

    Identification(String value) {
        this.value = value;
    }
}
