package model.dao;

import model.entity.Product;
import java.util.List;

public interface ProductDao {

 boolean insert(Product product);

 boolean remove(int identifier);

 boolean updateByIdentifier(int identifier, Product newProduct);

 List<Product> findAll();

}
