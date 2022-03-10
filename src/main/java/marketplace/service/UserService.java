package marketplace.service;

import marketplace.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}

