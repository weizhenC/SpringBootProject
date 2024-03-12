package com.jac.mvc.final_project_dec13.service;
import com.jac.mvc.final_project_dec13.DTO.UserRegistrationDTO;
import com.jac.mvc.final_project_dec13.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-13
 * Project: final_project_dec13
 */
public interface UserService  extends UserDetailsService{
    User save(UserRegistrationDTO registrationDTO);

}

