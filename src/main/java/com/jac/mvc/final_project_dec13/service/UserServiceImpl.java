package com.jac.mvc.final_project_dec13.service;

import com.jac.mvc.final_project_dec13.DTO.UserRegistrationDTO;
import com.jac.mvc.final_project_dec13.model.Role;
import com.jac.mvc.final_project_dec13.model.User;
import com.jac.mvc.final_project_dec13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-13
 * Project: final_project_dec13
 */

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(),
                registrationDTO.getLastName(), registrationDTO.getEmail(),
                passwordEncoder.encode(registrationDTO.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

//    @Override
//    public User save(UserRegistrationDTO registrationDTO) {
//
//        Role userRole;
//        if ("ROLE_ADMIN".equals(registrationDTO.getRole())) {
//            userRole = new Role("ROLE_ADMIN");
//        } else {
//            userRole = new Role("ROLE_USER");
//        }
//
//        User user = new User(
//                registrationDTO.getFirstName(),
//                registrationDTO.getLastName(),
//                registrationDTO.getEmail(),
//                passwordEncoder.encode(registrationDTO.getPassword()),
//                Arrays.asList(userRole)
//        );
//
//        return userRepository.save(user);
//    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


}

