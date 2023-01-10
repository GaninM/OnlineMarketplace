package marketplace.service.impl;

import marketplace.model.Product;
import marketplace.repository.ProductRepository;
import marketplace.service.ProductService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findByName(String productName) {
        return productRepository.findByTitle(productName);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProductPriceForId(Long id, int productPrice) {
        Product product = productRepository.findById(id).get();
        product.setStartPrice(productPrice);
        try (Connection connection = DriverManager.getConnection("jdbc.datasource.url", "jdbc.datasource.username",
                "jdbc.datasource.password")) {
            String sqlRequest = "UPDATE products SET  = " + productPrice + " WHERE id = " + id + ";";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e.getSQLState());
        }
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


}
