package marketplace.controller;

import marketplace.model.Product;
import marketplace.model.User;
import marketplace.service.BidService;
import marketplace.service.ProductService;
import marketplace.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final UserService userService;
    private final BidService bidService;

    public AdminController(ProductService productService, UserService userService, BidService bidService) {
        this.productService = productService;
        this.userService = userService;
        this.bidService = bidService;
    }

    @GetMapping(value = "/products")
    public String findAllProductForAdmin(Model model) {
        List<Product> adminProducts = productService.findAll();
        model.addAttribute("adminProducts", adminProducts);
        return "/admin-product-list";
    }

    @GetMapping("/product-update/{id}")
    public String productUpdateForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id).get();
        model.addAttribute("product", product);
        return "/admin-product-update";
    }

    @PostMapping("/product-update/{id}")
    public String productUpdate(Product product) {
        productService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/admin/products";
    }


    ///////////////////////////

    @GetMapping(value = "/users")
    public String findAllUserForAdmin(Model model) {
        List<User> adminUsers = userService.findAll();
        model.addAttribute("adminUsers", adminUsers);
        return "/admin-user-list";
    }


    @GetMapping("/user-update/{id}")
    public String userUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id).get();
        model.addAttribute("user", user);
        return "/admin-user-update";
    }

    @PostMapping("/user-update/{id}")
    public String productUpdate(User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        bidService.deleteByProductId(id);
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
}
