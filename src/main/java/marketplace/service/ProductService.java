package marketplace.service;

import marketplace.model.Product;

import java.util.List;


public interface ProductService {

    Product findByName(String productName);

    Product saveProduct(Product product);

    List<Product> findAll();
}
