package dto;

import model.entity.Product;

public class ProductDto {
  public String name;
  public String description;
  public double price;
  public int amount;
  public int identifier;

  public ProductDto(String name, String description, double price, int amount) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.amount = amount;
  }

  public ProductDto(String name, String description, double price, int amount, int identifier) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.amount = amount;
    this.identifier = identifier;
  }

  public ProductDto(Product product){
    this.name = product.getName();
    this.description = product.getDescription();
    this.price = product.getPrice();
    this.amount = product.getAmount();
    this.identifier = product.getIdentifier();
  }
}
