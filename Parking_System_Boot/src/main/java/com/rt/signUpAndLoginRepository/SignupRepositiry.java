package com.rt.signUpAndLoginRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.signUpAndLoginEntity.User;

@Repository
public interface SignupRepositiry extends JpaRepository<User, Integer> {
	
	@Query("SELECT COUNT(u) FROM User u WHERE u.email = :email")
	long checkUserCount(@Param("email") String email);


}
