package marketplace.controller;

import marketplace.model.Bid;
import marketplace.model.Product;
import marketplace.model.User;
import marketplace.repository.UserRepository;
import marketplace.service.BidService;
import marketplace.service.ProductService;
import marketplace.validator.ProductValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import java.util.Objects;

@Controller
public class ProductController {

    private final ProductService productService;
    private final BidService bidService;
    private final UserRepository userRepository;
    private final ProductValidator productValidator;


    public ProductController(ProductService productService, BidService bidService, UserRepository userRepository, ProductValidator productValidator) {
        this.productService = productService;
        this.bidService = bidService;

        this.userRepository = userRepository;
        this.productValidator = productValidator;
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
    public String createProduct(@ModelAttribute("productForm") Product product, Principal principal,
                                BindingResult bindingResult) {
        productValidator.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            return "product-create";
        }

        User user = userRepository.findByUsername(principal.getName());
        product.setOwnerId(user.getId());
        productService.save(product);
        return "redirect:/products";
    }

//
//    @RequestMapping("/product-delete/{id}")
//    public String deleteProduct(@PathVariable Long id, Principal principal) {
//        User user = userRepository.findByUsername(principal.getName());
//        Optional<Product> product = productRepository.findById(id);
//        if (user.getId().equals(product.get().getOwnerId())) {
//            productService.deleteById(id);
//        }
//        return "redirect:/products";
//    }

    @GetMapping("/product-info/{id}")
    public String getProductInfo(@PathVariable Long id, Model model) {
        Product modelProduct = productService.findById(id).get();
        model.addAttribute("modelProduct", modelProduct);
        model.addAttribute("modelBid", new Bid());
        return "product-info";
    }

    @PostMapping("/product-info/{id}")
    public String postProductInfo(@PathVariable Long id, @ModelAttribute("modelProduct") Product modelProduct,
                                  @ModelAttribute("modelBid") Bid modelBid, Principal principal) {

        Product product = productService.findById(modelProduct.getId()).get();

        if (Objects.equals(product.getOwnerId(), userRepository.findByUsername(principal.getName()).getId())) {
            return "redirect:/products";
        } else if (modelBid.getBidPrice() <= product.getStartPrice() &&
                modelBid.getBidPrice() % product.getBidInc() == 0) {
            return "/product-info";
        } else {

            Bid bid = new Bid();
            bid.setBidPrice(modelBid.getBidPrice());
            bid.setProductId(modelProduct.getId());
            bid.setUserId(userRepository.findByUsername(principal.getName()).getId());
            bidService.saveBid(bid);

            product.setStartPrice(modelBid.getBidPrice());
            product.setOfferId(bid.getId());
            productService.save(product);

            return "redirect:/products";
        }
    }

}
