package marketplace.service.impl;

import marketplace.model.User;
import marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = userRepository.findByUserLogin(userLogin);

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(user.getUserLogin(), user.getUserPassword(),
                grantedAuthoritySet);
    }
}
