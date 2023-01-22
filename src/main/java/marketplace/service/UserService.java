package marketplace.service;

import marketplace.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);

}

