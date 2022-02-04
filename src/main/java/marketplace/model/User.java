package marketplace.model;

import java.util.List;

public class User {

     private int userId;

     private String userName;

     private String userLogin;

     private String userPassword;

     private List<Product> userProducts;

     public User(int userId, String userName, String userLogin, String userPassword, List<Product> userProducts) {
          this.userId = userId;
          this.userName = userName;
          this.userLogin = userLogin;
          this.userPassword = userPassword;
          this.userProducts = userProducts;
     }

     public User() {
     }

     public int getUserId() {
          return userId;
     }

     public void setUserId(int userId) {
          this.userId = userId;
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
