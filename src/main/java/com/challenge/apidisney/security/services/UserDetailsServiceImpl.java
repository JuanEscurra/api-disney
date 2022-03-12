package com.challenge.apidisney.security.services;

import com.challenge.apidisney.domain.dao.UserRepository;
import com.challenge.apidisney.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User currentUser = repository.findByEmail(email);
        UserDetails user = new org.springframework.security.core.userdetails.User(email, currentUser.getPassword(),
                true, true, true, true,
                AuthorityUtils.createAuthorityList("usuario"));
        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException("No hay un usuario ingresado");
    }
}
