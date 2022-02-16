package marketplace.service;

import marketplace.model.User;

public interface UserService {

    boolean save(User user);

    User findByUserLogin(String userLogin);

}

