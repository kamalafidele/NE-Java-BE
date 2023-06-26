package rw.rca.SpringSecurityTemplate.Services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rw.rca.SpringSecurityTemplate.Models.User;
import rw.rca.SpringSecurityTemplate.Repositories.UserRepository;
import rw.rca.SpringSecurityTemplate.Security.UserDetailsImpl;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User with username "+username+" not found"));
        return UserDetailsImpl.build(user);
    }
}
