package marketplace.service;

import marketplace.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    Product findByName(String productName);

    void save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void deleteById(Long id);


    void updateProductPriceForId(Long id, int productPrice);

}
