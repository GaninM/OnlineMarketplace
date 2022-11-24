package marketplace.repository;

import marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);

    Product save(Product product);
}
