package marketplace.service;

import marketplace.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(User user);

    User findByUsername(String username);

}

