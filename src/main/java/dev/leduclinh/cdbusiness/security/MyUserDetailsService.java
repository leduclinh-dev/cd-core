package dev.leduclinh.cdbusiness.security;

import dev.leduclinh.cdbusiness.domain.entities.UserEntity;
import dev.leduclinh.cdbusiness.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        MyUserDetail loginUser = new MyUserDetail(userEntity.getUsername(), userEntity.getPassword(),true, true, true, true,null);
        loginUser.setId(userEntity.getId());
        loginUser.setEmail(userEntity.getEmail());
        loginUser.setUsername(userEntity.getUsername());
        loginUser.setRole(userEntity.getRole());
        return loginUser;
    }
}
