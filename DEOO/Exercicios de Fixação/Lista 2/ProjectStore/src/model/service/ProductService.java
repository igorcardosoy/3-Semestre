package model.service;

import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.entity.Product;

import java.util.List;

public class ProductService {

  private final ProductDao productDao;
  int identifierIndex;

  public ProductService(){
    productDao = ProductDaoImpl.getInstance();
    identifierIndex = 1;
  }

  public boolean addProduct(Product product){
      if (product != null){
        product.setIdentifier(identifierIndex);
        if (productDao.insert(product)){
          identifierIndexControl();
          return true;
        }
      }

      return false;
  }

  public boolean removeProduct(int identifier){
    if (identifier > 0){
      return productDao.remove(identifier);
    }

    return false;
  }

  public boolean attProduct(int identifier, Product newProduct){
    if (identifier > 0 && newProduct != null){
      return productDao.updateByIdentifier(identifier, newProduct);
    }

    return false;
  }

  public List<Product> getAllProducts(){
    return this.productDao.findAll();
  }


  private void identifierIndexControl(){
    this.identifierIndex++;
  }
}
