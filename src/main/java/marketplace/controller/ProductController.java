package marketplace.controller;

import marketplace.model.Product;
import marketplace.model.User;
import marketplace.repository.ProductRepository;
import marketplace.repository.UserRepository;
import marketplace.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService productService;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository, UserRepository userRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/products")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Model model) {
        model.addAttribute("productForm", new Product());
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(@ModelAttribute("productFrom")Product product, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        product.setOwnerId(user.getId());
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @RequestMapping("/product-delete/{id}")
    public String deleteProduct(@PathVariable Long id, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Optional<Product> product = productRepository.findById(id);
        if (user.getId().equals(product.get().getOwnerId())) {
            productService.deleteById(id);
        }
        return "redirect:/products";
    }

}
