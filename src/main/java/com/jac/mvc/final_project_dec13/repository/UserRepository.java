package com.jac.mvc.final_project_dec13.repository;

import com.jac.mvc.final_project_dec13.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-13
 * Project: final_project_dec13
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}

