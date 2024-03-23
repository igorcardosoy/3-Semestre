package model.entity.persons.Utils;


public final class Phone {

    private final String number;
    private final String areaCode;
    private final String countryCode;

    public Phone(String number, String areaCode, String countryCode) {
        this.number = number;
        this.areaCode = areaCode;
        this.countryCode = countryCode;
    }

    public Phone(Phone phone) {
        this.number = phone.getNumber();
        this.areaCode = phone.getAreaCode();
        this.countryCode = phone.getCountryCode();
    }

    public String getFormatedNumber() {
        return String.format(" +%s %s %s-%s", countryCode, areaCode, number.substring(0, 4), number.substring(4));
    }

    public String getNumber() {
        return number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
