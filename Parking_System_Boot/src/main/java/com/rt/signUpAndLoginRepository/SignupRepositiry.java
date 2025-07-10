package com.rt.signUpAndLoginRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.signUpAndLoginEntity.User;

@Repository
public interface SignupRepositiry extends JpaRepository<User, Integer> {

	User findByEmailAndRole(String email, String role);

	boolean existsByRoleIgnoreCase(String string);

	boolean existsByEmailIgnoreCase(String email);


}
