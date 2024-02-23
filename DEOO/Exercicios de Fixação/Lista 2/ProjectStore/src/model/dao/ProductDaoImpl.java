package model.dao;

import model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

  private static ProductDaoImpl instance;
  private final List<Product> products;

  private ProductDaoImpl(){
    products = new ArrayList<>(5);
  }

  public static ProductDao getInstance(){
    if (instance == null){
      instance = new ProductDaoImpl();
    }

    return instance;
  }

  private boolean findProduct(Product findProduct){

    for (Product product : this.products){
      if (product.getIdentifier() == findProduct.getIdentifier() || product.getName().equals(findProduct.getName()))
        return true;
    }

    return false;
  }

  private int findIndexByIdentifier(int identifier){

    int index = 0;

    for (Product productDao : this.products){
      if (productDao.getIdentifier() == identifier){
        return index;
      }

      index++;
    }

    return -1;
  }

  @Override
  public boolean insert(Product product) {

    if (!findProduct(product)){
      this.products.add(product);
      return true;
    }

    return false;
  }

  @Override
  public boolean remove(int identifier) {

    if (!this.products.isEmpty()){
      int index = findIndexByIdentifier(identifier);

      if (index > -1){
        this.products.remove(index);
        return true;
      }
    }

    return false;
  }

  @Override
  public boolean updateByIdentifier(int identifier, Product newProduct) {

    int index = findIndexByIdentifier(identifier);

    if (index > -1){
      this.products.set(index, newProduct);
      return true;
    }

    return false;
  }

  @Override
  public List<Product> findAll() {
    return this.products;
  }
}
