package com.jac.mvc.final_project_dec13.service;

import com.jac.mvc.final_project_dec13.DTO.UserRegistrationDTO;
import com.jac.mvc.final_project_dec13.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-13
 * Project: final_project_dec13
 */

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
        UserRegistrationDTO userDTO = new UserRegistrationDTO();
        userDTO.setFirstName("luke");
        userDTO.setLastName("yang");
        userDTO.setEmail("luke@gmail.com");
        userDTO.setPassword("1234");

        userService.save(userDTO);

        // 进一步的断言和测试逻辑
    }

}

