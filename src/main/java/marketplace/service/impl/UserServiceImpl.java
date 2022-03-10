package marketplace.service.impl;

import marketplace.model.Role;
import marketplace.model.User;
import marketplace.repository.RoleRepository;
import marketplace.repository.UserRepository;
import marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
       user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
       Set<Role> roles = new HashSet<>();
       roles.add(roleRepository.getById(1L));
       user.setRoles(roles);
       userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}