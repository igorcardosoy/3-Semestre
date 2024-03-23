package model.entity.payment;

public class CreditCard {
    private final String number;
    private final String name;
    private final String expirationDate;
    private final String securityCode;

    public CreditCard(String number, String name, String expirationDate, String securityCode) {
        this.number = number;
        this.name = name;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }
}
