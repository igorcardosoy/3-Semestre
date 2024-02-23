package model.entity;

public class Product {
  private String name;
  private String description;
  private double price;
  private int amount;
  private int identifier;

  public Product(String name, String description, double price, int amount, int identifier) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.amount = amount;
    this.identifier = identifier;
  }

  public Product(String name, String description, double price, int amount) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getIdentifier() {
    return identifier;
  }

  public void setIdentifier(int identifier) {
    this.identifier = identifier;
  }
}
