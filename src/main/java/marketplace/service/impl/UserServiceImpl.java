package marketplace.service.impl;

import marketplace.model.User;
import marketplace.repository.UserRepository;
import marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
       user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
       userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUserLogin(String userLogin) {
        return userRepository.findByUserLogin(userLogin);
    }
}
