package marketplace.model;

import java.util.List;

public class User {

     private int id;

     private String userName;

     private String userLogin;

     private String userPassword;

     private List<Product> userProducts;


     public User() {
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

     public String getUserLogin() {
          return userLogin;
     }

     public void setUserLogin(String userLogin) {
          this.userLogin = userLogin;
     }

     public String getUserPassword() {
          return userPassword;
     }

     public void setUserPassword(String userPassword) {
          this.userPassword = userPassword;
     }

     public List<Product> getUserProducts() {
          return userProducts;
     }

     public void setUserProducts(List<Product> userProducts) {
          this.userProducts = userProducts;
     }
}
