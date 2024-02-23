package controller;

import dto.ProductDto;
import model.entity.Product;
import model.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

  private final ProductService service;

  public ProductController(){
    this.service = new ProductService();
  }

  public boolean addProduct(ProductDto newProduct){
    return service.addProduct(new Product(newProduct.name, newProduct.description, newProduct.price, newProduct.amount));
  }

  public boolean removeProduct(int identifier){
    return service.removeProduct(identifier);
  }

  public boolean attProduct(int identifier, ProductDto newProduct){
    return service.attProduct(
            identifier,
            new Product(
              newProduct.name,
              newProduct.description,
              newProduct.price,
              newProduct.amount,
              newProduct.identifier
            )
    );
  }

  public List<ProductDto> getAllProducts(){
    List<ProductDto> productDtos = new ArrayList<>();
    for (Product product : service.getAllProducts()){
      productDtos.add(new ProductDto(product));
    }

    return productDtos;
  }
}
